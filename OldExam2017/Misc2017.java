import javax.naming.PartialResultException;

public class Misc2017 {

    /* 1.1
     * -------------------------------------------
     * Is this true or false?
     * There can be only one method named 'donald'?
     *
     * False.
     * There can be multiple methods called donald,
     * if they have different parameters.
     *
     * ============================================
     *
     * 1.2
     * --------------------------------------------
     * When a variable a is declared with A 'a' and a method m
     * with void m(B b), under what conditions will the call m(a)
     * compile?
     *
     * It will compile according to these two scenarios, either method
     * should share the same type for A and B , such as for example
     * both being an int or double
     * or this will compile if A is a subclass of type,
     * which means it would be a derived type, thus it would compile
     *
     *
     * class A extends B {}
     * class B {}
     * A a = new A();
     *
     *
     * ==============================================
     *
     * 1.3
     * ----------------------------------------------
     * Write a method double segsum(double[] a, int from, int to)
     * that returns the sum of a i.e. the sum of elements between position
     * from (including) and ti (not including). E.g when a is {9, 8, 7, 6, 5, 4},
     * segsum(a, 2, 4) will return 13
     * v v v v v v v v v v v v v v v v v v v v v v v v
     */

    double sum(double[] a, int from, int to){
        int sum=0;
        int ARRAY_SIZE=a.length;
        if(ARRAY_SIZE==0){
            return 0;
        }

        if(from==to-1){
            return sum+=a[from];
        }

        sum+=a[from];

        return sum(a,from+1,to)+sum;

    }

    //TODO
    // check your work

    /* ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^  ^
     *===============================================
     *
     * 1.4
     * ------------------------------------------------
     * Write a method double segsumRobust(double[] a, int from, int to)
     * that does thesame calculation, but now checks whether from and
     * to are within their bounds as described above. If one of them or
     * both are not, the exception IllegalSegment should be thrown.
     * The Exception class is provided in the template code. The caller
     * of the method will have to handle the exception
     *
     * v v v v v v v v v v v v v v v v v v v v v v v v
     */

    double sumRobust(double[] a, int from, int to) throws IllegalSegment
    {
        int sum=0;
        int ARRAY_SIZE=a.length;
        if(ARRAY_SIZE==0){
            return 0;
        }
        if ((from>ARRAY_SIZE || from<ARRAY_SIZE)||(to>ARRAY_SIZE || to<ARRAY_SIZE)){
            throw new IllegalSegment("Array Out Of Bond or Invalid");
        }

        if(from==to-1){
            return sum+=a[from];
        }

        sum+=a[from];

        return sumRobust(a,from+1,to)+sum;

    }

    class IllegalSegment extends Exception {
        IllegalSegment() { }

        IllegalSegment( String s ) {
            super( s );
        }
    }


    /* ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
     * ===============================================
     *
     * 1.5
     * -----------------------------------------------
     * Consider the following class
     * What are the local variables (not including parameters) in this class?
     * v v v v v v v v v v v v v v v v v v v v  v v v v
     */
    class Inauguration {
        String president;
        String[] speech;
        long numberOfPeople;

        void printSpeech(int n) {
            int x;     // One local variable
            for (int i = 0; i < speech.length; i++) { // i = two local variable
                String p = speech[i]; // Three local variable
                x = p.length();
                numberOfPeople += numberOfPeople * x * 1000;
                System.out.println(p);
            }
        }
    }

    /*
     * There are three local variable:
     * int i, int x and String p
     *
     * ==================================================
     */

    void run(){
        double arr[] = {1,2,3,4};
        System.out.println(sum(arr,0,3));
        try {
            System.out.println(sumRobust(arr,1,5));
        }catch (IllegalSegment e){
            System.out.println("Error encountered because "+ e);
        }

    }

    public static void main(String[] args) {
        Misc2017 m = new Misc2017();
        m.run();
    }
}
