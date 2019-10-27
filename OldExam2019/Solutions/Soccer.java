// Soccer - complete version for 2ip90 exam Jan 2019

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
import java.util.*;

class Soccer extends JPanel implements ActionListener {
    JFrame frame;
    JButton button;
    ArrayList<Ball> balls;
    
    void buildIt() {     
        frame = new JFrame("Shaping");
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
        balls.add( new BlueBall( getWidth()/2, getHeight()/2 ) );
        balls.add( new BlueBall( getWidth()/5, getHeight()*4/5 ) );
        balls.add( new PinkBall( getWidth()/5, getHeight()/5 ) );
        balls.add( new DottedBall( getWidth()/2, getHeight()/2 - 50 ) );
        balls.add( new ChameleonBall( getWidth()/4, getHeight()*3/4 ) );
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

class ChameleonBall extends Ball {
    Color color;
    Random random;
    
    ChameleonBall( int startx, int starty ) {
        super( startx, starty );
        random = new Random();
    }
    
    @Override 
    public void draw( Graphics g ) {
       g.setColor( color );
       g.fillOval(x - size/2, y - size/2, size, size); 
    }
    
    @Override
    public void kick() {
        color = new Color( random.nextInt(255), random.nextInt(255), random.nextInt(255) );
    }
}

class DottedBall extends BlueBall {
    int INCREMENT = 5;
    int dotSize = 8;
    Color dotColor = Color.BLACK;
    
    DottedBall( int startx, int starty ) {
        super( startx, starty );
    }
    
    @Override
    public void draw( Graphics g ) {
        super.draw(g);
        g.setColor( dotColor );
        g.fillOval(x - dotSize/2, y - dotSize/2, dotSize, dotSize);
    }
    
    @Override
    public void kick() {
        super.kick();
        size += INCREMENT;
    }
}

class PinkBall extends Ball {
    Color color = Color.PINK;
    int arcDiam = 10;
    
    PinkBall( int startx, int starty ) {
        super( startx, starty );
    }
    
    @Override
    public void draw( Graphics g ) {
        g.setColor( color );
        g.fillRoundRect(x - size/2, y - size/2, size, size, arcDiam, arcDiam);
    }
    
    @Override
    public void kick() {
        x += DISPLACEMENT;
        y += DISPLACEMENT;
    }
}
