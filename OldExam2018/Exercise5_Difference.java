// starter file for exam 2ip90
import javafx.geometry.Pos;

import java.util.*;

class Difference {
    boolean allZero(int[] nums) {  //Used Internet! Check carefully!
        if (nums.length == 0)
            return false;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                return false;
            }
        }

        return true;
    }
    int[] difference(int[] nums){
        int SIZE = nums.length -1;
        int[] temp = new int[SIZE];
        for (int i=0; i<SIZE;i++){
            temp[i] = nums[i+1] - nums[i];
        }
        return temp;
    }
    boolean isConstant(int[] nums){
        int SIZE = nums.length -1;
        if (allZero(nums)) {
            return true;
        }
        else if(nums.length==1 || nums.length==0)
            return true;
        else {
            if (allZero(difference(nums)))
                return true;
            else
                return false;

        }
    }

    boolean isLinear(int[] nums){
        if(isConstant(difference(nums))){
            return true;
        }else
            return false;
    }

    void printFunction(int[] nums){
        if (!isLinear(nums))
            return;
        int CONSTANT = difference(nums)[0];
        int ADDITION = nums[0];
        System.out.println(CONSTANT+"x + "+ADDITION);
    }

    boolean PositiveDiff(int[] diff) {
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] < 0)
                return false;
        }
        return true;
    }

    int degreeCalc(int[]nums,int count){
        if (!isConstant(nums) && PositiveDiff(difference(nums))){
            count+=1;
            return degreeCalc(difference(nums),count);
        }
        return count;
    }

    int degree(int[] nums){
        int count=0;
        return degreeCalc(nums,count);
    }


    
    void demo() {
        // UNCOMMENT WHEN YOU HAVE ADDED THE METHOD
        int[] numbersZero = { 0, 0, 0, 0 };
        System.out.println( "allZero: "+ allZero( numbersZero )  );
        
        int[] numbersQuadratic = { 1, 4, 9, 16 };
        System.out.println( "difference: "+ Arrays.toString( difference( numbersQuadratic ) ) );
        
        int[] numbersConstant = {6};
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
                           