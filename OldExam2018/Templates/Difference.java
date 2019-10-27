// starter file for exam 2ip90  
import java.util.*;

class Difference {
    // ADD YOUR METHODS HERE
    
    void demo() {
        // UNCOMMENT WHEN YOU HAVE ADDED THE METHOD
        int[] numbersZero = { 0, 0, 0, 0 };
        //System.out.println( "allZero: "+ allZero( numbersZero )  );
        
        int[] numbersQuadratic = { 1, 4, 9, 16 };
        //System.out.println( "difference: "+ Arrays.toString( difference( numbersQuadratic ) ) );
        
        int[] numbersConstant = { 6, 6, 6 };
        //System.out.println( "isConstant: "+ isConstant( numbersConstant )  );
        
        int[] numbersLinear = new int[]{ 1, 4, 7, 10 };
        //System.out.println( "isLinear: "+ isLinear( numbersLinear )  );
        
        System.out.print( "printFunction: ");
        //printFunction( numbersLinear );
        
        // should print 2
        //System.out.println( "degree: "+ degree( numbersQuadratic ) );   
    }            
    
    public static void main( String[] a ) {
        ( new Difference() ).demo();
    }
}
                           