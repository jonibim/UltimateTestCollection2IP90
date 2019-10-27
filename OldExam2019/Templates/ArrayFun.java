/** 
 * @author
 * @id 
 */

import java.util.Arrays;

// Question 2 -- Array Fun

class ArrayFun {
    double sum(double[] a) {
        //TODO
        return 0; //change this
    }
    
    double[] colsum(double[][] m) {
        //TODO
        return null; //change this
    }
    
    int segsum(int[] a, int from, int upto) {
        //TODO
        return 0; //change this
    }
    
    void demo() {
        double[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, -2, -3},
            {2, 4, 6}
        }; 
        double[] result = colsum(matrix);
        System.out.println(Arrays.toString(result));
    }
}