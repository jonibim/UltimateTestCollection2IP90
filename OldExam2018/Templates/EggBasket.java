/**  EggBasket -- exam Oct 2018 - student version 
  * @author ADD
  * @id     ADD
  */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EggBasket {
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

class EggPanel extends JPanel {
    ArrayList<Egg> eggs = new ArrayList<Egg>();
    
    EggPanel() {
        Egg plainEgg = new Egg(10, 10);
        eggs.add(plainEgg);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (Egg egg : eggs) {
            egg.draw(g);
        }
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
}