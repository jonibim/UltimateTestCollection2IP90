import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
        BlueBall blue2 = new BlueBall(15,getHeight()-15);
        PinkBall pink1 = new PinkBall(30,30);
        BlueBall dottedBall = new DottedBall(getWidth()/2,25);
        ChameleonBall chamBall = new ChameleonBall(30,getHeight()-30);
        balls.add(dottedBall);
        balls.add(pink1);
        balls.add( blue1 );
        balls.add( blue2);
        balls.add(chamBall);
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
    Color color = Color.blue;



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

class DottedBall extends BlueBall{
    int startXBlue;
    int startYBlue;
    BlueBall b;
    Color color = Color.BLACK;

    DottedBall(int startx, int starty) {
        super(startx, starty);
        b = new BlueBall(startx+1, starty+1);
    }

    @Override
    public void draw( Graphics g ) {
        b.draw(g);
        g.setColor( color );
        g.fillOval(x - size/4, y - size/4, size/2, size/2);
    }

    @Override
    public void kick() {
        size += 5;
        b.x += DISPLACEMENT;
        x += DISPLACEMENT;
    }
}

class ChameleonBall extends Ball{
    Color color = Color.PINK;
    Random r = new Random();
    Color[] someColors = {
            Color.black, Color.red, Color.green, Color.blue, Color.magenta };

    ChameleonBall( int startx, int starty ) {
        super( startx, starty );
    }

    @Override
    public void draw( Graphics g ) {
        g.setColor( color );
        g.fillOval(x - size / 2, y - size / 2, size, size);
        //g.drawRoundRect(x - size/2, y - size/2, size, size,10,10);
    }

    @Override
    public void kick() {
        color = someColors[r.nextInt(someColors.length)];
    }

}

class PinkBall extends Ball{
    Color color = Color.PINK;

    PinkBall( int startx, int starty ) {
        super( startx, starty );
    }

    @Override
    public void draw( Graphics g ) {
        g.setColor( color );
        g.fillRoundRect(x - size/2, y - size/2, size, size,10,10);
        g.drawRoundRect(x - size/2, y - size/2, size, size,10,10);
    }

    @Override
    public void kick() {
        y += DISPLACEMENT;
        x += DISPLACEMENT;
    }

}
