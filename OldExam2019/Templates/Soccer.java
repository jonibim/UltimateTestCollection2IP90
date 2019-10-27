// Soccer - student version for exam Nov 2016, question 3

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
import java.util.*;

class Soccer extends JPanel implements ActionListener {
    JFrame frame;
    JButton button;
    ArrayList<Ball> balls;
    
    void buildIt() {     
        frame = new JFrame("Soccere");
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
        BlueBall blue1 = new BlueBall( getWidth()/2, getHeight()/2 );
        balls.add( blue1 );
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


