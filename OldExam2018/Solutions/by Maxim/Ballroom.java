/** Ballroom.java 
  *   @author
  *   @id
  */

/* Don't make your lines longer than this one *********************************/

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;

class Ballroom {
  BallroomPanel ballroomPanel = new BallroomPanel();
  Timer timer;
  
  void createGUI() {
    // create the GUI on the event thread.
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        final JFrame frame = new JFrame("Ballroom");
        frame.add(ballroomPanel, BorderLayout.CENTER);
        frame.setSize( 600, 400 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        ballroomPanel.addBalls();
        
        timer = new Timer( 50, ballroomPanel);
        timer.start();
      }
    });
  }
  
  public static void main( String[] a ) {
    new Ballroom().createGUI();
  }
}

class BallroomPanel extends JPanel implements ActionListener {
  Timer timer;
  ArrayList<Ball> balls = 
    new ArrayList<Ball>();  // the list of monsters on the screen
  
  void addBalls() {
    balls.add( new Ball( 20, 10 ));
    balls.add( new Ball( 20+80, 10 ));
    balls.add( new RedBall( 20, 10 ));
    balls.add( new BlinkingBall( 20+40, 10 ));
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    for (Ball ball : balls) {
      ball.draw( g );
    }
  }
  
  public void actionPerformed( ActionEvent e ) {
    for (Ball ball : balls) {
      ball.step();
    }
    repaint();
  }
  
}

class Ball {
  int radius;

  int x;    // x coordinate center (pixel coordinates)
  int y;    // y coordinate center (pixel coordinates)
  
  int fallStep;
  
  Color ballColor;  

  Ball() {
    // location extremely top left
    this(0,0);
  }
  
  Ball( int x, int y ) {
    this.x = x;
    this.y = y;
    
    radius = 20;
    fallStep = 20;
    ballColor = Color.BLUE;
  }
  
  // update the ball because a time step has passed
  void step( ) {
    y += fallStep;
  }
  
  void draw( Graphics g ) {
    // draw ball
    g.setColor( ballColor );
    g.fillOval( x - radius/2, y - radius/2, radius, radius );
  }
  
}

class RedBall extends Ball {
    RedBall( int x, int y ) {
        this.x = x;
        this.y = y;
        fallStep = 40;
        ballColor = Color.RED;
    }
}

class BlinkingBall extends Ball {
    BlinkingBall( int x, int y ) {
        this.x = x;
        this.y = y;
        startTimer();
    }
    
    void toggleColor() {
        if (ballColor == Color.RED) {
            ballColor = Color.BLUE;
        } else {
            ballColor = Color.RED;
        }
    }
    
    Timer timer = new Timer(200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            toggleColor();
        }
    });
    
    void startTimer(){
        timer.start();  
    }

}


