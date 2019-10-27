import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Draws a square where the user clicked with the mouse.
 * This is a solution up to point 4 of the exercise
 */
class MouseDemo extends JPanel implements MouseListener, ActionListener { // TC: Implements both MouseListener (for mouse press) and ActionListener (for 'enter' press in size text field) 
  private int x, y; // location of last mouse press
  private int size; // initial size of shape
  
  private JFrame frame;
  
  // The text field to enter the size of the square in
  private JTextField sizeField;
  
  // The current color of the square
  private Color currentColor;
  
  
  public MouseDemo() {
    frame = new JFrame("MouseDemo");
    frame.add( this ); // TC: This class is itself also a JPanel (it extends JPanel) and thus can be added to the frame
    
    this.size = 25;
    
    this.x = 150;
    this.y = 150;
    
    this.addMouseListener(this); // TC: MouseDemo is its own MouseListener (since it implements MouseListener)
    
    sizeField = new JTextField("" + size);
    sizeField.addActionListener(this); // TC: This is to listen to when the 'enter' key is pressed in the size textfield.  
    frame.add(sizeField, BorderLayout.SOUTH);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setLocation(200, 200);
    frame.setVisible(true);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // TC: Get the current size from the size textfield
    int size = Integer.parseInt(sizeField.getText());
    
    // TC: Define the color of the square
    Color squareColor = getCurrentColor(); 
    g.setColor(squareColor);
    g.fillRect(x - size / 2, y - size / 2, size, size); // TC: Draw the square. The center of the square is the location of the last mouse press
  }
  
  // the method from MouseListener we're interested in this time
  @Override
  public void mousePressed( MouseEvent e) {
    x = e.getX(); // TC: get the location of the mouse press
    y = e.getY();
    
    repaint(); // TC: Make sure to call repaint otherwise the 'paintComponent' method won't be triggered
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    repaint(); // TC: This is the only thing we need to do to redraw the square with the new size since the size field is consulted in the 'paintComponent' method.
  }
  
  private Color getCurrentColor() {
    // TC: Calculate the color based on the position of the mouse press.
    // TC: If the user pressed on the far left side the factor will be 0. If the user pressed in the far right side the factor will be 1. Pressing in the middle will result in a factor of 0.5. Etc..
    double factor = (double)x / getWidth();
    
  
    int newBlue = (int)(255 * factor); 
    int newRed = 255 - newBlue; 
    
    return new Color(newRed, 0, newBlue);
  }
  
  // TC: the other four methods from MouseListener. We don't use them, but they have to be present
  @Override public void mouseReleased( MouseEvent e) { }
  @Override public void mouseClicked( MouseEvent e) { }
  @Override public void mouseEntered( MouseEvent e) { }
  @Override public void mouseExited( MouseEvent e) { }
  
  public static void main(String[] args) {
    new MouseDemo();
  }
} 
