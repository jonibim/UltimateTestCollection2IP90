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
  ArrayList<Baall> balls =
    new ArrayList<Baall>();  // the list of monsters on the screen

  void addBalls() {
    balls.add( new Baall( 20, 10 ));
    balls.add( new Baall( 100, 10 ));
    balls.add( new RedBall( 540, 10 ));
    balls.add( new BlinkingBall( 310 , 10 ));
      balls.add(new BouncingBall(50, 50));
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    for (Baall ball : balls) {
      ball.draw( g );
    }
  }

  public void actionPerformed( ActionEvent e ) {
    for (Baall ball : balls) {
      ball.step();
    }
    repaint();
  }

}

class Baall {
  int radius;

  int x;    // x coordinate center (pixel coordinates)
  int y;    // y coordinate center (pixel coordinates)

  int fallStep;

  Color ballColor;

  Baall() {
    // location extremely top left
    this(0,0);
  }

  Baall( int x, int y ) {
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

class RedBall extends Baall {

    RedBall( int x, int y ) {
        super( x, y );

        fallStep = 40;
        ballColor = Color.RED;
    }
}

class BlinkingBall extends Baall {
    int phase = 0;


    BlinkingBall( int x, int y ) {
        super( x, y );
    }

    @Override
    void step( ) {
        y += fallStep;
        phase++;
    }

    @Override
    void draw( Graphics g ) {
        if( phase % 4 == 0 ) {
            if( ballColor == Color.BLUE) {
                ballColor = Color.RED;
            } else {
                ballColor = Color.BLUE;
            }
        }
        // draw ball
        g.setColor( ballColor );
        g.fillOval( x - radius/2, y - radius/2, radius, radius );
    }
}

//PLEASE NOTE THAT THIS SHOULD BE DONE IN A SEPERATE FOLDER
//BUT FOR SAKE OF SIMPLICITY AND IN ORDER TO AVOID A MESS OF
//FOLDERS AND PROJECTS I WILL DO IT IN ONE SIMPLE CLASS WITH
//SOME SMALL ADDITIONS. THE IDEOLOGY BEHIND THIS WOULD BE THE
//THE SAME IF WE WOULD APPLY THIS TO THE WHOLE PROJECT

//TODO
// Check the work, Elaborate more, Make it more advanced
class BouncingBall extends Baall {
    Random r = new Random();

    public BouncingBall(int x, int y) {
        super(x, y);
    }

    @Override
    void step() {
        if (y > 330) {
            fallStep = -fallStep;
        }
        if (y < 20) {
            fallStep = -fallStep;
        }
        super.step();
    }
}









