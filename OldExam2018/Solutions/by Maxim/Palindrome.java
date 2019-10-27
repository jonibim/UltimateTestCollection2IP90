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
    
    // recursive reverse method
    String reverse(String s) {
        String output = "";
        int length = s.length();
        if (length == 0 || length == 1) {
            return s;
        }
        String firstChar = s.substring(0,1);
        String lastChar = s.substring(length-1, length);
        String middleChars = reverse(s.substring(1,length-1));
        output = lastChar + middleChars + firstChar; 
        return output;
    }
    
    boolean isPalindrome(String s) {
        return (s.equals(reverse(s)));
    }
    
    // running methods
    void run() {
        System.out.println(reverse("Hallo"));
        System.out.println(isPalindrome("lol"));
        System.out.println(isPalindrome("haha"));
    }
    
    
    // main function
    public static void main(String[] args) {
        (new ClassName()).run();
    }
    
}