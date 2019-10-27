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
class Statistics {
    public double[] input = new double[]{5.5, 3.5, 10, 10};
    public int[] input2 = new int[]{1,3,3};
    
    // sum method
    double sum(double[] a) {
        double output = 0;
        
        for (double n : a) {
            output += n;
        }
        
        return output;
    }
    
    // mean method
    double mean(double[] a) {
        double amount = a.length;
        double sum = sum(a);
        double output = sum/amount;
        return output;
        
    }
    
    // max method, used in the prio method
    int max(int[] a) {
        int output = Integer.MIN_VALUE;
        for (int n : a) {
            if (n > output) {
                output = n;
            }
        }
        return output;
    }
    
    // prio method
    int[] prio(int[] a) {
        int max = max(a);
        int c = 0;
        int temp;
        
        for (int n : a) {
            if (n == max) {
                temp = a[0];
                a[0] = max;
                a[c] = temp;
            }
            c++;
        }
        return a;
    }
    
    // run method, just calls all other method to check
    void run() {
        System.out.println(sum(input));
        System.out.println(mean(input));
        System.out.println(Arrays.toString(prio(input2)));
    }
    
    // main function
    public static void main(String[] args) {
        (new Statistics()).run();
    }
    
}