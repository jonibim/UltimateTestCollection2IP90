import javax.swing.*;
import java.awt.*;

/**
 * Class demonstrates the use of a different LayoutManager and (background) color 
 */
class FlyingColors {
  
  JFrame frame;
  JLabel label;
  JPanel panel;
  
  FlyingColors() {
    frame = new JFrame("Flying Colors");
    label = new JLabel("What's my background color?");
    panel = new JPanel();
  }
  
  void setUpGui() {
    frame.setSize(800, 600);
    
    label.setBackground(Color.pink);
    label.setOpaque(true);
    frame.add(label, BorderLayout.NORTH);
    
    int rows = 10;
    int cols = 8;
    
    GridLayout layout = new GridLayout(rows, cols); // TC: Create a new grid layout using the set rows and cols
    panel.setLayout(layout);
        
    // Determine step size
    int stepSize = 255 / (rows * cols); // TC: define by how much the red color (255,0,0) should change to white (255,255,255) between the different labels
    
    for (int i = 0; i < rows * cols; i++) {
      Color currentGradient = new Color(255, i * stepSize, i * stepSize);
      
      JLabel subLabel = new JLabel(); // TC: We do not need to keep a reference to the label so we can declare it as a local variable inside the loop
      subLabel.setBackground(currentGradient); 
      subLabel.setOpaque(true); // TC: Make sure to change the opaque value to true, otherwise no background color is shown at all
      
      panel.add(subLabel); // TC: add the label to the panel
    }
    
    frame.add(panel, BorderLayout.CENTER);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    FlyingColors fc = new FlyingColors();
    fc.setUpGui();
  }
}
