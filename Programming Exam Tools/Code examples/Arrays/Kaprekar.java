/**
 * author: Maxim Snoep
 * student-number: 1313517
 * date: --/--/20--
 * course: --
 * assignment: --
 */

//imports
import java.util.*;
import java.*;

//class initialization
class Kaprekar {
    Scanner scn = new Scanner(System.in);
    private int input;
    
    void readInput() {
        input = scn.nextInt();
    }
    
    // a % 10 -> last digit
    // a / 1:10:100:1000 -> first digit
    int[] int2array(int n) {
        int[] output = new int[4];
        
        for (int x = 0; x < 4; x++) {
            int temp = n/(int)(Math.pow(10,x)) % 10;
            output[3-x] = temp;
        }
        return output;
    }
    
    int array2int(int[] n) {
        int output = 0;
        
        for (int x = 0; x < 4; x++) {
            int temp = n[x]*(int)(Math.pow(10,x));
            output += temp;
        }
        return output;
    }
    
    int[] reverseArray(int[] n) {
        int[] output = new int[4];
        for (int x = 0; x < 4; x++) {
            output[x] = n[3-x];
        }  
        return output;
    }
    
    int nextKaprekar(int n) {
        int[] big_array = new int[4];
        int[] small_array = new int[4];
        int big_integer;
        int small_integer;
        int output;
        
        big_array = int2array(n);
        
        Arrays.sort(big_array);
        small_array = reverseArray(big_array);
        

        big_integer = array2int(big_array);
        small_integer = array2int(small_array);

        output = big_integer - small_integer;
        
        System.out.println(big_integer + " - " + small_integer + " = " + output);
        return output;
    }
    
    boolean doKaprekar(int n) {
        int firstKaprekar = nextKaprekar(n);
        int secondKaprekar = nextKaprekar(firstKaprekar);
        
        if (firstKaprekar == secondKaprekar) {
            System.out.println('!');
            return true;
        } else {
            doKaprekar(secondKaprekar);
        }
        return true;
    }
    
    // a function
    void run() {
        readInput();
        doKaprekar(input);
    }

    // main function
    public static void main(String[] args) {
        (new Kaprekar()).run();
    }
    
}