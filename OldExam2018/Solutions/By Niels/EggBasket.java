/**  EggBasket -- exam Oct 2018 - student version 
  * @author Niels Gorter
  * @id     1332678
  * @date   30/10/2018
  */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EggBasket  {
    JFrame frame;
    EggPanel eggPanel;
    public JButton moveButton;
  
    void buildGUI() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                frame = new JFrame( "Egg Basket" );
                
                moveButton = new JButton("Move");
                frame.add(moveButton, BorderLayout.NORTH);

                eggPanel = new EggPanel();
                frame.add(eggPanel);
                
                frame.setSize(500, 400);
                frame.setLocation(200, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                frame.setVisible(true);
            }
        });
    }
        
    public static void main(String[] args) {
        (new EggBasket()).buildGUI();
    }
}

class EggPanel extends JPanel implements ActionListener {
    ArrayList<Egg> eggs = new ArrayList<Egg>();
    
    EggPanel() {
        Egg plainEgg = new Egg(10, 10);
        eggs.add(plainEgg);
        eggs.add( new Egg(50, 10));
        eggs.add( new EasterEgg(100, 10));
        //"non-static x cannot be referenced from static context"
        //EggBasket.moveButton.addActionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (Egg egg : eggs) {
            egg.draw(g);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Egg egg : eggs) {
            egg.move();
        }
        repaint();
    }
}       

class Egg {
    int x; // x-coord of position on the screen
    int y; // y-coord of position on the screen
    int moveDistance = 10;
    int promotionThreshold = 5;
    int sizeX = 30;
    int sizeY = 50;
    
    Egg(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, sizeX, sizeY);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, sizeX, sizeY);        
    }
    
    void move() {
        x += moveDistance;
    }
}

class EasterEgg extends Egg {
    EasterEgg(int x, int y) {
        super(x, y);
    }
    
    @Override 
    void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, sizeX, sizeY);
        g.setColor(Color.BLUE);
        g.fillOval(x + sizeX/3, y + sizeY/3, sizeX/4, sizeX/4);
        g.setColor(Color.RED);
        g.fillOval(x + sizeX/2, y + sizeY/2, sizeX/4, sizeX/4);    
    }
    
    @Override 
    void move() {
        x += moveDistance;
        int originalSizeX = sizeX;
        sizeX = sizeY;
        sizeY = originalSizeX;
    }
}