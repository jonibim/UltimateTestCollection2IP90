/**
 * author: Maxim Snoep
 * student-number: 1313517
 * date: --/--/20--
 * course: --
 * assignment: --
 */

//imports
import java.util.*;

//class initialization
class ClassName {
    Scanner scn = new Scanner(System.in);
    public String output;
    
    // reading input
    void read() {
        output = scn.nextLine();
    }
    
    // writing input
    void write() {
        System.out.println(output);
    }
    
    // running read and write method
    void run() {
        read();
        write();
    }
    
    
    // main function
    public static void main(String[] args) {
        (new ClassName()).run();
    }
    
}