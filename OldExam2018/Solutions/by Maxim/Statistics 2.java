import java.util.*;

class Statistics {
 
    // test if the output is correct
    void run(int[] c) {
        System.out.println(Arrays.toString(c));
    }
    
    double sum(double[] a) {
        double sum = 0;
        
        for(int x = 0; x < a.length; x++) {
            sum = sum + a[x];
        }
        
        return sum;
    }
    
    double mean(double[] a) {
        double sum = sum(a);
        
        return (sum / a.length);
    }
    
    int[] prio(int[] a) {
        
        int max = 0;
        int i = 0;
        
        for(int x = 0; x < a.length; x++) {
            if (max < a[x]) {
                i = x;
            }
            max = Math.max(max, a[x]);
        }
        
        a[i] = a[0];
        a[0] = max;
        
        return a;
    }
    
    public static void main(String[] args) {
        Statistics s = new Statistics();
        
        int[] b = {1, 2, 3};
        
        s.run(s.prio(b));
    }
}