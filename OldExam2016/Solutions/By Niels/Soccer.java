// Soccer - student version for exam Nov 2016, question 3
/*
 * @author Buster Franken
 *     @id 0912005
 *    date 29_10_2018
 */
/* Don't make your lines longer than this one *********************************/


import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
import java.util.*;

public class Soccer extends JPanel implements ActionListener {
    JFrame frame;
    JButton button;
    ArrayList<Ball> balls;
    
    void buildIt() {     
        frame = new JFrame("Soccer");
        frame.add( this );
               
        button = new JButton("Kick");
        frame.add( button, BorderLayout.NORTH );
        button.addActionListener( this );
               
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        
        createBalls();
    }
    
    void createBalls() {
        balls = new ArrayList<>();
        BlueBall   blue1 = new BlueBall( getWidth()/2, getHeight()/2 );
        BlueBall   blue2 = new BlueBall( 15, getHeight()-15 );
        PinkBall   pink1 = new PinkBall( 20, 20 );
        DottedBall dots1 = new DottedBall( getWidth()/2, getHeight()/4 );
        ChameleonBall cham1 = new ChameleonBall( 30, getHeight()-30 );
        
        balls.add( blue1 );
        balls.add( blue2 );
        balls.add( pink1 );
        balls.add( dots1 );
        balls.add( cham1 );
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        for (Ball b : balls) {
            b.draw(g);
        }
    }    
    
    public void actionPerformed( ActionEvent e ) {        
        for (Ball b : balls) {
            b.kick();
        } 
        repaint();
    }   
        
    public static void main(String[] args) {
        new Soccer().buildIt(); 
    }
}  

abstract class Ball {
    int x, y;     // position of center in pixels
    int size;     // diameter in pixels
    int DISPLACEMENT = 10;
    
    public Ball( ) {
        size = 30;
    }
    
    public Ball( int startx, int starty ) {
        x = startx;
        y = starty;
        size = 30;
    }
    
    public abstract void kick();
    
    public abstract void draw( Graphics g );
}

class BlueBall extends Ball {
    Color color = Color.BLUE;
    
    BlueBall( int startx, int starty ) {
        super( startx, starty );
    }
    
    @Override
    public void draw( Graphics g ) {
        g.setColor( color );
        g.fillOval(x - size/2, y - size/2, size, size);
    }
    
    @Override
    public void kick() {
        x += DISPLACEMENT;
    }
}

class PinkBall extends Ball {
    Color color = Color.PINK;
    int arcSize = 15;
    PinkBall(int startx, int starty) {
        super(startx, starty);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(x - size/2, y - size/2, size, size, arcSize, arcSize);
    }
    
    @Override
    public void kick() {
        x += DISPLACEMENT;
        y += DISPLACEMENT;
    }
}

class DottedBall extends BlueBall {
    int dotSize = 5;
    
    DottedBall(int startx, int starty) {
        super(startx, starty);
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Color black = new Color(0, 0, 0);
        g.setColor(black);
        g.fillOval(x - dotSize/2, y - dotSize/2, dotSize, dotSize);
    }
    
    @Override
    public void kick() {
        super.kick();
        size += 2;
    }
}

class ChameleonBall extends Ball {
    Random random = new Random();
    Color color;
    
    ChameleonBall(int startx, int starty) {
        super(startx, starty);
        randomizeColor();
    }
    
    void randomizeColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        color = new Color(r, g, b);
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x - size/2, y - size/2, size, size);
    }
    
    @Override
    public void kick() {
        randomizeColor();
    }
}
