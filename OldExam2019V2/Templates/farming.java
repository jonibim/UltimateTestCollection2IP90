/**  Farming -- 2ip90 exam Nov 2019 - student version 
  * @author ADD
  * @id     ADD
  */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Farming {
  JFrame frame;
  FarmPanel farmPanel;
  JButton moveButton;
  
  void buildGUI() {
    SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        frame = new JFrame( "Farming" );
        
        moveButton = new JButton("Move");
        frame.add(moveButton, BorderLayout.NORTH);
        
        farmPanel = new FarmPanel();
        frame.add(farmPanel);
        
        frame.setSize(500, 400);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
      }
    });
  }
  
  public static void main(String[] args) {
    (new Farming()).buildGUI();
  }
}

class FarmPanel extends JPanel {
  Tractor tractor; 
  
  FarmPanel() {
    tractor = new Tractor(10, 20);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    tractor.draw(g);
  }
}       

class Tractor {
  int x; // x-coord of position on the screen
  int y; // y-coord of position on the screen
  int moveDistance = 10; // distance to move per click
  int sizeRear = 32; // size of rear wheel
  
  
  Tractor(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  void draw(Graphics g) {
    int tyreWidth = sizeRear / 4;
    g.setColor(Color.BLACK);
    g.fillOval(x, y, sizeRear, sizeRear);        
    g.setColor(Color.BLUE);
    g.fillOval(x+tyreWidth, y+tyreWidth, sizeRear-2*tyreWidth, sizeRear-2*tyreWidth);
  }
}