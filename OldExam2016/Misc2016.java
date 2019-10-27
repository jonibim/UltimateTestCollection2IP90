public class Misc2016 {
    /*
     * 1.1
     * -------------------------
     * True or False? A variable of type Garden (see question 1.5)
     * can only store instances of the class Garden?
     *
     * TRUE
     *
     * =========================
     *
     * 1.2
     * --------------------------
     * True or False? An instance variable in a class can not
     * be changed by a method in that class
     *
     * FALSE
     *
     * =========================
     *
     * 1.3
     * -------------------------
     * Consider the following method. Suppose this method is called and the
     * commented part will produce a NullPointerException. What will
     * be printed?
     *
     * DEMONSTRATION
     * v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v v
     */
    void fragment() {
        int x = 0;
        try {
            x += 1;
            throw new NullPointerException();// here a NullPointerException is thrown
            //x+=2;
        } catch (NullPointerException e) {
            x += 4;
        }
        System.out.println(x);
    }
    /* ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
     * The number 5 will be returned because at the point
     * where the exception is going to be thrown
     * the line below it won't be run, but we will go
     * directly to the catch function, in which we will add
     * to our x + 4. Since the x was already assigned with a 1 in it
     * (the line before throwing an exception) the result is going to
     * be 4+1=5;
     *
     * ======================================
     *
     * 1.4
     * --------------------------------------
     * The intention of the following method is to sort the array a by
     * swapping two neighboring elements when they are positioned
     * in the wrong order.
     * There are two mistakes, however (not counting possible inefficiencies).
     * Indicate in what the mistakes are and repair them,
     * maintaining the algorithm. You have to change only a few lines.
     *
     * v v v v v v v v v v v v v v v v v v v v
     */

    void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            //for (int j = 0; j < a.length; j++) {
            //We want to search till i , so we dont have to search the item itself
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int swap = a[j]; //Fixed Swap
                    a[j] = a[j+1];
                    a[j+1] = swap;
                }
            }
        }
    }

    /* ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
     *=====================================================
     *
     * 1.5
     * ----------------------------------------------------
     * What is the number of objects (instances) of class Garden created by
     * the following method?
     * v v v v v v v v v v v v v v v v v v v v v v v v v v
     */
    void create() {
        Garden aap; //Not initialized
        Garden noot; //Not initialized
        Garden[] street;
        aap = new Garden(); //One
        noot = aap; //We copy the same object instance
        street = new Garden[10];
    }

    //Only one

    class Garden {
        int length;
        int width;

        int getArea() {
            return length * width;
        }
    }
    /*
     * ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
     */

    public static void main(String[] args) {
        Misc2016 d = new Misc2016();
        d.fragment();
    }
}
