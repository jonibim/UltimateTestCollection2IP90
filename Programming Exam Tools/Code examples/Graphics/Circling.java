import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that animates a square that circles around the center of the frame.
 */
public class Circling extends JPanel implements ActionListener, ChangeListener { // TC: ActionListener is used by Timer, ChangeListener by JSlider
  private JFrame frame;
  
  private int centerX;
  private int centerY;
  
  private double angle; // TC: The current 'angle' in degrees (!) of the square in reference to the center
  private double deltaAngle; // TC: The delta (in degrees!) that should be added to the angle each time the timer 'ticks'
  
  private Timer timer; // TC: On each 'tick' the square needs to move
  
  private JSlider speedSlider; // TC: Slider to adjust the rotation speed
  
  private JButton startStopButton; 
  
  public Circling() {
    frame = new JFrame();
    
    timer = new Timer(1000/60, this); // TC: Fluent animations have 60 frames per second
    
    speedSlider = new JSlider(); 
    speedSlider.setMinimum(1); // TC: The minimun degrees that can be added to the angle on each timer tick
    speedSlider.setMaximum(30); // TC: The maximum degrees that can be added to the angle on each timer tick
    speedSlider.setValue(2); // TC: The initial value is 2
    
    deltaAngle = speedSlider.getValue(); // TC: Set the initial delta to the initial value of the slider
    
    startStopButton = new JButton("Start");
  }
  
  public void setUpAndStart() {
    frame.setSize(350, 350);
    
    speedSlider.addChangeListener(this); // TC: Since Circling implements ChangeListener 'this' can be registered as a change listener of the slider.
    frame.add(speedSlider, BorderLayout.SOUTH);
    
    startStopButton.addActionListener(this); // TC: Since Circling implements an ActionListener 'this' can be registered as a action listener of the button
    frame.add(startStopButton, BorderLayout.NORTH);
    
    frame.add(this, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    startStop(); // TC: Start the animation by calling this method
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    setCenter(); // TC: Helper method to define the current center coordinates of the panel
    
    g.setColor(Color.BLACK);
    int centerTextWidth = g.getFontMetrics().stringWidth("center"); // TC: Get the width (in pixels) of the text 'center' as it would take once written on the screen 
    int centerTextHeight = 12; // TC: We use the default font which has a size of 12
    g.drawString("center", centerX - centerTextWidth / 2, centerY - centerTextHeight / 2); // TC: Centering the text 'center' using the earlier calculated center and text width + height
    
    g.setColor(Color.BLUE);
    int radius = 100;
    int x = (int) (radius * Math.cos(Math.toRadians(angle))); // TC: Calculate current x and y of the square using the angle and the provided formula. Note that we have to convert the angle to radians (as it is in degrees)
    int y = (int) (radius * Math.sin(Math.toRadians(angle)));
    int size = 25;
    g.fillRect(centerX + x - size / 2, centerY + y - size / 2, size, size); // TC: Draw and fill the square
    
  }
  
  private void setCenter() {
    // TC: Helper method to set the current center x and y coordinates
    centerX = getWidth() / 2;
    centerY = getHeight() / 2;
  }
  
  @Override
  public void stateChanged(ChangeEvent e) {
    // TC: This method is called whenever somebody changes the position of the speed slider
    deltaAngle = speedSlider.getValue(); // TC: We choose to update the value of the delta instead of the set time of the Timer  
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TC: This method is called by both the Timer as the start/stop button
    if (e.getSource() == timer) { // TC: The Timer called this method
      updateAngle(); 
    } else if (e.getSource() == startStopButton) { // TC: The start/stop button called this method
      startStop();
    }
    
  }
  
  private void updateAngle() {
    angle = (angle + deltaAngle) % 360; // TC: Make sure that the angle always stays within the range 0 .. 360
    
    repaint(); // TC: Call repaint so that we see that the sqaure 'moved'
  }
  
  private void startStop() {
    if (!timer.isRunning()) { // TC: Check if the timer is running
      timer.start(); // TC: It is not running, start it
      startStopButton.setText("Stop"); // TC: Change the text on the button to "Stop"
    } else {
      timer.stop(); // TC: It is running, stop it
      startStopButton.setText("Start"); // TC: Change the text on the button to "Start"
    }
  }
  
  public static void main(String[] args) {
    Circling circling = new Circling();
    circling.setUpAndStart();
  }
}
