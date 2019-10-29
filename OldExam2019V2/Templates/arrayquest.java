/** 
 * @author
 * @id 
 */

import java.util.Arrays;

// Question 2 -- Array Fun

class ArrayQuest {
    int[] clamp(int[] a, int max) {
        //TODO
        return null; //change this
    }
    
    int maxpos(String s) {
        //TODO
        return 0; //change this
    }
    
    String sort(String s) {
        //TODO
        return null; //change this
    }
    
    void demo() {
        //2.1
        int[] a = {1, 5, 2, 3, 6, 7}; 
        int m = 5;
        System.out.println(Arrays.toString(a) + " " + m);
        System.out.println(Arrays.toString(clamp(a, m)));
        
        //2.2
        String s = "lal";
        System.out.println(s + "-> " + maxpos("lal"));
        
        //2.3
        String t = "yebab";
        System.out.println(t + "-> " + sort(t));
    }
    
    public void main(String[] a) {
      (new ArrayQuest()).demo();
    }
}