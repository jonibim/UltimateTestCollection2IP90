public class Misc2019 {

    /*
     * 1.1
     * --------------
     * Mention all the local variables (not including parameters)
     *
     */


    class Valentine {
        String title;
        String[] cards;

        void printRoses(int n) {
            int x;
            for (int i = 0; i < cards.length; i++) {
                String c = cards[i];
                x = c.length();
                if (c.length() >= n) {
                    System.out.print(c + " ");
                }
                System.out.println(i);
            }
        }

    }
    /*
     * The local variables are int x, String c and int i
     *
     * ======================================================
     *
     * 1.2
     * --------------
     * Consider the following code
     * Suppose the method fragment is called and the method m will produce a
     * NullPointerException. What will be printed?
     *
     */

    class ExceptionFragment {
        void fragment() {
            int x = 0;
            try {
                x += 1;
                m();
                x += 2;
            } catch (NullPointerException e) {
                x += 4;
            }
            System.out.println(x);
        }

        // this method throws a NullPointerException
        void m() {
            //...
            throw new NullPointerException();
        }
    }

    /*
     * The number 5 will be printed
     *
     * ==========================================
     *
     * 1.3
     * ------------------------------------------
     * There are two things wrong with the following code
     * (that there is no main method is not considered wrong).
     * Give the line number and explain what is wrong.
     *
     */
    class Square {

        double size;

        void setSize(double s) {
            //s = size;
            size = s;
        }

        double getArea() {
            return size * size;
        }
    }

    //class SquareDemo()
    class SquareDemo{
        void demo() {
            //Square mySquare; Initialize the square
            Square mySquare = new Square();
            mySquare.setSize(5);
            System.out.println(mySquare.getArea());
        }
    }

    /*
     * ============================================================
     */


    void run() {
        new ExceptionFragment().fragment();
        new SquareDemo().demo();
    }

    public static void main(String[] args) {
        new Misc2019().run();

    }
}
