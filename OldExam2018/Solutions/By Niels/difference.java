// starter file for exam 2ip90  
/* @author Niels Gorter
 * @id 1332678
 * @date 30/10/2018
 * difference.java
 */
import java.util.*;

class Difference {
    // ADD YOUR METHODS HERE
    
    boolean allZero(int[] nums) {
        int zeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroes++;
            }
        }
        if (zeroes == nums.length && nums.length > 0) {
            return true;
        }
        return false;
    }
    
    int[] difference(int[] nums) {
        int[] diff = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i+1] - nums[i];
        }
        return diff;
    }
    
    boolean isConstant(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        return allZero(difference(nums));
    }
    
    boolean isLinear(int[] nums) {
        return isConstant(difference(nums));
    }
    
    //prints linear function of form: (y=)ax+b
    void printFunction(int[] nums) {
        if (isLinear(nums)) {
            int diff[] = difference(nums);
            int a = diff[0];;
            int b = nums[0];
            System.out.println(a + "x + " + b);
        } else {
            System.out.println("The argument is not a linear array.");
        }
    }
    
    int degree(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (isLinear(nums)) {
            return 1;
        } else {
            return 1 + degree(difference(nums));
        }
    }
    
    void demo() {
        // UNCOMMENT WHEN YOU HAVE ADDED THE METHOD
        int[] numbersZero = { 0, 0, 0, 0 };
        System.out.println( "allZero: "+ allZero( numbersZero )  );
        
        int[] numbersQuadratic = { 1, 4, 9, 16 };
        System.out.println( "difference: "+ Arrays.toString( 
                                            difference( numbersQuadratic ) ) );
        
        int[] numbersConstant = { 6, 6, 6 };
        System.out.println( "isConstant: "+ isConstant( numbersConstant )  );
        
        int[] numbersLinear = new int[]{ 1, 4, 7, 10 };
        System.out.println( "isLinear: "+ isLinear( numbersLinear )  );
        
        System.out.print( "printFunction: ");
        printFunction( numbersLinear );
        
        // should print 2
        System.out.println( "degree: "+ degree( numbersQuadratic ) );   
    }            
    
    public static void main( String[] a ) {
        ( new Difference() ).demo();
    }
}
                           