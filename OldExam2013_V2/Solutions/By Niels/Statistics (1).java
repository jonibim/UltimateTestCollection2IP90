import java.util.Arrays;

class Statistics {
    //1.1
    double sum(double[] a) {
        double sum = 0;
        
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;        
    }
    
    //1.2
    double mean(double[] a) {
        return sum(a) / a.length;  
    }
    
    //1.3
    int[] prio(int[] a) {
        int[] prio = new int[a.length];
        Arrays.sort(a); //sorts array in ascending order
        
        //reverse an array
        for (int i = 0; i < a.length; i++) {
            prio[i] = a[a.length - 1 - i];
        }
        
        return prio;
    }
    
    public static void main(String... args) {
        Statistics test = new Statistics();
        double[] a = {20,10,50,40,30};
        System.out.println(test.mean(a));
    }
    
}