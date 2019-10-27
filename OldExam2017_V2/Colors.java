import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Colors {
    JFrame frame;
    JPanel colorPanel;
    int numcols = 6;
    int numrows = 4;

    void buildColorPanel() {
        colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(numrows, numcols));

        int numcells = numrows * numcols;
        for (int i = 0; i < numcells; i++) {
            FlyingLabel label = new FlyingLabel();
            label.setOpaque(true);

            int whiteness = i * 255 / numcells;
            label.setBackground(new Color(255, whiteness, whiteness));

            colorPanel.add(label);
        }

        frame.add(colorPanel);
    }

    void buildGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame("Flying Colors");

                buildColorPanel();

                frame.setSize(500, 300);
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        (new Colors()).buildGUI();
    }
}

class FlyingLabel extends JLabel implements MouseListener {

    Color origColor;

    FlyingLabel() {
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (getBackground() == Color.YELLOW) {
            setBackground(origColor);
        } else {
            origColor = getBackground();
            setBackground(Color.YELLOW);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}