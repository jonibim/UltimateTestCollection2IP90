import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Farming {
    JFrame frame;
    FarmPanel farmPanel;
    JButton moveButton;
    //Define the solveButton
    JButton solveButton;

    void buildGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame("Farming");

                moveButton = new JButton("Move");
                solveButton = new JButton("Solve");
                frame.add(moveButton, BorderLayout.NORTH);
                //Add the solveButton to the frame and location
                frame.add(solveButton, BorderLayout.SOUTH);


                farmPanel = new FarmPanel();
                frame.add(farmPanel);

                //We need to add the ActionListeners for the buttons to work
                solveButton.addActionListener(farmPanel);
                moveButton.addActionListener(farmPanel);

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

class FarmPanel extends JPanel implements ActionListener {
    //The random for the random position
    Random random = new Random();
    //The arraylist for tractors
    ArrayList<Tractor> tractors = new ArrayList<>();
    Tractor tractor;
    //Define Tractor2
    Tractor tractor2;

    FarmPanel() {
        //Adding 100 tractors to the array
        //with random positions
        //Boundaries of the randoms is set to the panel size width and length
        for (int i = 0; i <= 100; i++) {
            tractors.add(new Tractor(random.nextInt(500), random.nextInt(400)));
        }
        tractor = new Tractor(10, 40);
        //Add Tractor2
        tractor2 = new Tractor(200, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        //Add super otherwise the paint will appear broken or duplicated (ghosting)
        super.paintComponent(g);
        tractor.draw(g);
        //Draw Tractor 2
        tractor2.draw(g);
        //Draw all the tractors in array
        for (int i = 0; i < tractors.size(); i++) {
            tractors.get(i).draw(g);

        }
    }

    //The action perform for the button
    @Override
    public void actionPerformed(ActionEvent e) {
        //Check with what Button are we dealing with
        //By checking the text that we have defined on them
        if (e.getActionCommand() == "Move")
            //Move all the tractors according to the method move
            for (int i = 0; i < tractors.size(); i++) {
                tractors.get(i).move();
            }
        if (e.getActionCommand() == "Solve")
            //Remove half of the tractors of the array
            //If the button is pressed again it will remove half of the tractors
            //from the the half that was created before
            for (int i = 0; i < tractors.size() / 2; i++) {
                tractors.remove(i);
            }
        //Repaint to remove the old copies
        repaint();
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

    //The move method
    void move() {
        x = x + moveDistance;
    }

    void draw(Graphics g) {
        //The values are defined to give the best representation of a truck
        int locXRearTire = x + 60;
        int locYFrontBody = y - 30;
        int locXBackBody = x;
        int tyreWidth = sizeRear / 4;
        int bodySize = 50;
        int widthSize = 40;

        //This sets up the Rear Tire
        g.setColor(Color.BLACK);
        g.fillOval(locXRearTire, y, sizeRear, sizeRear);
        g.setColor(Color.BLUE);
        g.fillOval(locXRearTire + tyreWidth, y + tyreWidth, sizeRear - 2 * tyreWidth, sizeRear - 2 * tyreWidth);

        //This sets up the Front Tire
        g.setColor(Color.BLACK);
        g.fillOval(x, y, sizeRear, sizeRear);
        g.setColor(Color.BLUE);
        g.fillOval(x + tyreWidth, y + tyreWidth, sizeRear - 2 * tyreWidth, sizeRear - 2 * tyreWidth);

        //This sets up the Truck Body which are two rectangles
        g.setColor(Color.RED);
        g.fillRect(locXBackBody, locYFrontBody, bodySize, widthSize);
        g.fillRect(locXBackBody, y - 5, sizeRear * 3, widthSize / 2);

        // This sets up a small window for the truck
        g.setColor(Color.cyan);
        g.fillRect(locXBackBody + bodySize / 4, locYFrontBody + widthSize / 4, bodySize / 2, widthSize / 2);
    }
}