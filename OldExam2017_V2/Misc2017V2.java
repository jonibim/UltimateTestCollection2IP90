public class Misc2017V2 {

    /*
     * 1.1
     * --------------------------
     * True or False?
     * There can be only one method named foo in a class
     *
     * False. Method can share the same name
     * as long they have different parameters
     *
     * ============================
     *
     * 1.2
     * ----------------------------
     * True or False?
     * There can be only one local variable named x
     * in a class
     *
     * True
     *
     * =============================
     *
     * 1.3
     * -----------------------------
     * Consider the following code fragment
     *
     *  A a;
     *  B b;
     *  a = b;
     *
     * The first two lines are accepted by the
     * compiler. What should hold about A and B to
     * have the compiler accept the assignments?
     *
     * A should extend B
     *
     * ==============================
     *
     * 1.4
     * ------------------------------
     * Describe in word what the following method returns
     *
     */

    boolean m(int[] numbers) {
        boolean result = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] * numbers[i] == numbers[i + 1]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /*
     * The method is checking if the neighboor next to each element
     * is the square of that element. But the value that will be returned
     * will always be depended on the last two numbers
     * So if the last elements is the square of the previous element
     * than it will return true, otherwise false
     *
     * ======================================
     *
     * 1.5
     * --------------------------------------
     * What is wrong with the code?
     */

    class Square {
        double size;

        void setSize(double s) {
            size = s;
        }

        double getArea() {
            return size * size;
        }
    }

    class SquareDemo {
        //Square mySquare We need to initialize the object so thats why we create it
        // like this v v v v v v v  v
        Square mySquare = new Square();

        void demo() {
            mySquare.setSize(5);
            System.out.println(mySquare.getArea());
        }
    }

    /*
     * ====================================
     *
     * 1.6
     * ------------------------------------
     * Consider the following code
     * Mention all the local variables
     *
     */

    class Course {
        String title;
        int[] grades;

        void printGrades(int threshold) {
            int grade;  // One Variable
            for (int i = 0; i < grades.length; i++) { // +another one (the i)
                grade = grades[i];
                if (grade >= threshold) {
                    System.out.print(grade + " ");
                }
                System.out.println();
            }
        }
    }

    /*
     * There are two local variables:
     * int grade and int i
     *
     * =====================================
     *
     * 1.7
     * --------------------------------------
     *
     * What follows is a recursive method int power(int a, int b that computes a b
     * in a very efficient way. It is incomplete and contains some holes.
     * The holes are marked with A, B, C, and D. Complete it by mentioning
     * for each of the holes what should be filled in there. In hole A you
     * should fill in the minimal condition on the parameters under
     * which the method works correctly.
     *
     */

    // assume b is non negative
    int power(int a, int b) {
        if (b == 0) {
            return 1; //B
        } else if (b % 2 == 0) {
            return power(a * a, b / 2);
        } else {
            return power(a * a, (b - 1) / 2);
        }
    }

    void run() {
        int p[] = {2, 4, 4, 16};
        System.out.println(m(p));
        new SquareDemo().demo();
    }

    public static void main(String[] args) {
        new Misc2017V2().run();
    }
}
