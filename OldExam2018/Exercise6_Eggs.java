import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Exercise6_Eggs {
    JFrame frame;
    EggPanel eggPanel;
    JButton moveButton;

    void buildGUI() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                frame = new JFrame( "Egg Basket" );
                moveButton = new JButton("Move");
                frame.add(moveButton, BorderLayout.NORTH);
                eggPanel = new EggPanel();
                moveButton.addActionListener(eggPanel);
                frame.add(eggPanel);
                frame.setSize(500, 400);
                frame.setLocation(200, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }


    public static void main(String[] args) {
        (new Exercise6_Eggs()).buildGUI();
    }

}


class EggPanel extends JPanel implements ActionListener{
    ArrayList<Egg> eggs = new ArrayList<Egg>();

    EggPanel() {
        Egg plainEgg = new Egg(10, 10);
        Egg plainEggDolly = new Egg(10, 70);
        EasterEgg easter = new EasterEgg(200,10);
        eggs.add(plainEgg);
        eggs.add(plainEggDolly);
        eggs.add(easter);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Egg egg : eggs) {
            egg.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            eggs.get(0).move();
            eggs.get(1).move();
            eggs.get(2).move();
            repaint();
    }
}

class EasterEgg extends Egg{
    int degree=0;
    EasterEgg(int x, int y){
        this.x = x;
        this.y = y;
    }

    void move(){
        degree+=90;
        x+=moveDistance;
    }

    void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.YELLOW);
        g2d.rotate(Math.toRadians(degree),x+sizeX/2,y+sizeY/2);
        g2d.fillOval(x, y, sizeX, sizeY);
        g2d.setColor(Color.BLUE);
        g2d.drawOval(x, y, sizeX, sizeY);
    }

}

class Egg {
    int x; // x-coord of position on the screen
    int y; // y-coord of position on the screen
    int moveDistance = 10;
    int promotionThreshold = 5;
    int sizeX = 30;
    int sizeY = 50;
    Egg(){ }
    Egg(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void move(){
        this.x+=moveDistance;
    }
    void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, sizeX, sizeY);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, sizeX, sizeY);
    }
}