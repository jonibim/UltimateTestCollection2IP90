/** Monsters.java -- answer file for exam 2ip91 -- 24 January 2017
 *   @author
 *   @id
 */

/* Don't make your lines longer than this one *********************************/

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;

class Monsters {
    MonsterPanel monsterPanel = new MonsterPanel();
    Timer timer;
    
    void createGUI() {
        // create the GUI on the event thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Monster Mania");
                frame.add(monsterPanel, BorderLayout.CENTER);
                frame.setSize( 600, 400 );
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                
                monsterPanel.setBackground( Color.DARK_GRAY );
                monsterPanel.addMonsters();
                
                timer = new Timer( 50, monsterPanel);
                timer.start();
            }
        });
    }
    
    public static void main( String[] a ) {
        new Monsters().createGUI();
    }
}

class MonsterPanel extends JPanel implements ActionListener {
    ArrayList<Monster> monsters = 
        new ArrayList<Monster>();  // the list of monsters on the screen
    
    void addMonsters() {
        monsters.add( new Monster( 50, 40 ));
        monsters.add( new Monster( 530, 40 ));
        monsters.add( new SeeingMonster( 275, 175, Color.BLUE ));
        monsters.add( new MovingMonster( 25, 325));
        monsters.add( new BouncingMonster( 275, 325, 8, -6));
    }
    
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        for (Monster monster : monsters) {
            monster.draw( g );
        }
    }
    
    public void actionPerformed( ActionEvent e ) {
        for (Monster monster : monsters) {
            monster.step( this );
        }
        repaint();
    }  
}

class Monster {
    int size = 50;
    int arcSize = 10;  // defines roundedness of rounded rectangle
    int locx = 0;     // x coordinate center (pixel coordinates)
    int locy = 0;    // y coordinate center (pixel coordinates)
    Color fill = Color.YELLOW;   // inner color
    Color line = Color.BLACK;   // color of border
    int phase = 0;  // phase in the animation, a counter of time steps
    
    Monster() {
        // location extremely top left
        locx = 0;
        locy = 0;
    }
            
    Monster( int x, int y ) {
        locx = x;
        locy = y;
    }
    
    // update the monster because a time step has passed
    // the parameter monsterPanel can be used for getting 
    // information about the panel, e.g., the size
    void step( MonsterPanel monsterPanel ) {
        phase++;
    }
        
    void draw( Graphics g ) {
        // draw body
        g.setColor( fill );
        g.fillRoundRect( locx - size/2, locy - size/2, size, size, arcSize, arcSize );
        g.setColor( line );
        g.drawRoundRect( locx - size/2, locy -size/2, size, size, arcSize, arcSize );
        // draw mouth
        // every 5 time steps, mouth is changed
        if ( phase % 20 < 10 ) {
            int s = size/5; // size of closed mouth
            g.drawOval( locx - s/2, locy + size/6, s, s );
        } else {
            int s = size/3; // size of open mouth
            g.fillOval( locx - s/2, locy + size/6, size/3, size/3 );
        }
    }
}

class SeeingMonster extends Monster {
    
    Color eyesColor;
    
    SeeingMonster( int x, int y, Color eyesColor) {
        super(x, y);
        this.eyesColor = eyesColor;
    }
    
    void draw( Graphics g ) {
        // draw everything that was in Monster
        super.draw(g);
        // draw eyes
        g.setColor(eyesColor);
        g.fillOval( locx - 22, locy - size/3, size/2 - 5, size/2 - 5);
        g.fillOval( locx + 2, locy - size/3, size/2 - 5, size/2 - 5);
    }
}
                    
class MovingMonster extends Monster {
    
    MovingMonster( int x, int y ) {
        super( x, y );
    }
    
    void step( MonsterPanel monsterPanel ) {
        phase++;
        locx++;
    }
}

class BouncingMonster extends Monster { 
    
    int speedX;
    int speedY;
 
    BouncingMonster( int x, int y, int speedX, int speedY) {
        super( x, y );
        this.speedX = speedX;
        this.speedY = speedY;
    }
    
    void step( MonsterPanel monsterPanel ) {
        phase++;
        
        if (locx >= 558 || locx <= 25) {
            speedX = -speedX;
        }
        
        if (locy <= 25 || locy > 325) {
            speedY = -speedY;
        }
        
        locx = locx + speedX;
        locy = locy + speedY;
    }
}