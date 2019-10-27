import javax.swing.Timer;
import java.awt.event.*;

class TimerMethod {
    
    void write(){
        System.out.println("hoertje");
    }
    
    void startTimer(){
        timer.start();  
    }
    
    Timer timer = new Timer(200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            write();
        }
    });
    
    public static void main(String[] a){
        (new TimerMethod()).startTimer();
    } 
}
