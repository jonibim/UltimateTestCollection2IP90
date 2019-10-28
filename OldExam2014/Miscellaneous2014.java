public class Miscellaneous2014 {
    /*
     * 1.1
     * ---------------------
     * Write a method with header int possum( int[] numbers)
     * that adds up all the positive numbers in the array
     * numbers. For example, if a contains the numbers
     *  1, 2, 2, -3, 5, the callpossum(a) will return 10
     * ------------------
     */
    int possum(int [] numbers){
        int temp=0;
        for (int i=0; i<numbers.length;i++){
            if (numbers[i]>0){
                temp+=numbers[i];
            }
        }
        return temp;
    }

    /*
     * 1.2
     * ----------
     * Describe in words what does the code do?
     * v v v v v v v v v v v v v v v v v v v v v
     */
    boolean m(int[] numbers) {
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                result = true;
            }
        }
        return result;
    }
    /*
     * ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^
     * The method above checks if there is any zero in
     * a given array (the parameter numbers)
     * If there is a zero in the array, the flag
     * (boolean result) is switched to true,
     * thus returning true, otherwise it will keep
     * its initial values, false, and return it
     * ============================================
     */

    /*
     *1.3
     * -----------------------------------
     * Look at the changed code now. What does it do?
     * v v v v v v v v v v v v v v v v v v
     */
    boolean m2(int[] numbers) {
        boolean result = false;
        for (int i = 0; i < numbers.length; i++) {
            result = numbers[i] == 0;
        }
        return result;
    }

    /*
     * By removing the if statement, the boolean result
     * will be assigned to the result of the condition
     * specified for each element in the array
     * This means that the final value for the boolean result
     * would be depended by the last number in the array
     * If the last number is not zero, but there are other zeros
     * scattered in the array, the return boolean value would
     * be false
     * =====================================================
     */

    /*
     * 1.4
     * ---------------------------------------------
     * Fix the code
     *
     */
    //    class Square {
    //        double size;
    //        void setSize( double s ) {
    //        size = s;
    //    }
    //    double getArea() {
    //            return size ∗ size;
    //        }
    //    }
    //    class SquareDemo() {
    //        void demo() {
    //            Square mySquare;
    //            mySquare.setSize( 5 );
    //            System.out.println( mySquare.getArea() );
    //        }
    //    }

    static class Square {
        double size;
        void setSize( double s ) {
            size = s;
        }
        double getArea(){
            return size*size;
        }
    }
    static class SquareDemo {
        void demo() {
            Square mySquare = new Square(); //initialize the variable
            mySquare.setSize( 5 );
            System.out.println( mySquare.getArea() );
        }
    }

    //=================================================

    /*
     * 1.5
     * ---------------------------------------------
     * Consider the following program
     * Mention all the local variables
     * v v v v v v v v v v v v v v v v v v v v v
     */
    class Course {
        String title;
        int[] grades;
        void printGrades( int threshold ) {
            int grade;
            for (int i=0; i<grades.length; i++) {
                grade = grades[i];
                if ( grade >= threshold ) {
                    System.out.print( grade + " " );
                }
                System.out.println();
            }
        }
    }


    /*
     * The local variables for this program are
     * Inside the Course class & methods inside this class only:
     * grades, title;
     * Inside the method accessible only:
     * grade, i (from the for element)
     *
     * Parameters (threshold) may also be counted as local variables
     * but the exercise is ambiguous if we should either count those
     * as local variables or not
     *
     */



    void run(){
        int[] test = {0, 2, 4, 8};
        System.out.println(possum(test));
        System.out.println(m2(test));
    }

    public static void main(String[] args) {
        Miscellaneous2014 run = new Miscellaneous2014();
        run.run();
        SquareDemo m = new SquareDemo();
        m.demo();

    }
}
