/** Ballroom.java
  *   @author
  *   @id
  */

/* Don't make your lines longer than this one *********************************/

//TODO
// Add bounciness at the end of the screen
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
    new ArrayList<Baall>(); 

  void addBalls() {
    balls.add( new Baall( 20, 10 ));
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
