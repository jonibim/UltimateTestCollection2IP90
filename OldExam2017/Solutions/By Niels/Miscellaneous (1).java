/** Miscellaneous.java -- answer file for exam 2ip91 -- 24 January 2017
 * @author
 *    @id
 */

/* Don't make your lines longer than this one *********************************/

class Miscellaneous {
    void run() {
        System.out.println("test");
        double[] a = {10,20,30,40,50};
        System.out.println(segsum(a, 2, 4));
    }
    /*
     * 1.1
     * answer (true/false): false 
     * explanation: there can be mulptiple methods named donald if they have different parameters, for example:
     * donald() {}
     * donald(int x) {}
     */
    
    /*
     * 1.2
     * answer: We first need to make a main class B and subclass A that extends B, so that A and B are not incomparable
     * we also need to initialize A a to a new a so:
     * A a = new A();
     */
    
    // 1.3
    double segsum(double[] a, int from, int to) {
        double total = 0;
        for (int i = from; i < to; i++) {
            total += a[i];
        }
        return total;
    }
    
    // 1.4??????????????????
    double segsumRobust(double[] a, int from, int to) throws IllegalSegment {
        double total = 0;
        if (from < 0 || to < 0 || from > a.length || to > a.length) {
            throw new IllegalSegment(); 
        }
        for (int i = from; i < to; i++) {
            total += a[i];
        }
        
        return total;
    }
        
    
    /* 
     * 1.5
     * local variables: x, i, and p are in the body of printSpeech and are only visible there, so they are called local
     * variables
     */
    
    public static void main(String[] a) {
        Miscellaneous test = new Miscellaneous();
        test.run(); 
    }
      
}
    
class IllegalSegment extends Exception {
    IllegalSegment() { }
    
    IllegalSegment( String s ) {
        super( s );
    }
}
        
    
    
     