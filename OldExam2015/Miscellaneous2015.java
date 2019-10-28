public class Miscellaneous2015 {
    /*
     * 1.1
     * --------------------------------------
     * Describe in words what the following method returns
     */
    boolean m(int[] numbers){
        boolean result = false;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0){
                result = true;
            }
        }
        return result;
    }

    /*
     * The method checks if there is any Zero in the array,
     * if it find a zero somewhere in the array, by searching
     * with the for loop every elements, it switched the flag
     * (the boolean result) from false to true, and than returns
     * that value. If it doesn't find any zero it returns the
     * default value assigned to the flag which is false;
     * ===================================================
     */

    /*
     * 1.2 & 1.3
     * --------------------------------------------------
     * Fix the code below
     */

//    class Square{
//        double size;
//        void setSize(double s){
//            s = size
//    HERE WE ARE DOING THE OPPOSITE OF OUR
//    GOAL, WE WANT TO SET THE SIZE FOR THE SQUARE
//    BUT WE ARE DEFINING THE SIZE OF AN
//    NULL VARIABLE TO AN PARAMETER
//        }
//
//        double getArea(){
//            return size*size;
//        }
//    }
//
//    class SquareDemo(){
//    WE CANT DEFINE A CLASS WITHOUT THE BRACKETS
//        void demo(){
//            Square mySquare;
//             WE NEED TO INITIALIZE A CLASS BEFORE USING IT
//             BY USING THE 'NEW' COMMAND;
//            mySquare.setSize(5);
//            System.out.println(mySquare.getArea());
//        }
//    }

    //Fixed code
    class Square{
        double size;
        void setSize(double s){
            size = s;         //fixed this
        }

        double getArea(){
            return size*size;
        }
    }

    class SquareDemo{  //fixed this
        void demo(){
            Square mySquare = new Square();   //fixed this
            mySquare.setSize(5);
            System.out.println(mySquare.getArea());
        }
    }

    //===================================================

    /*
     *1.4
     * ----------------------------
     * Consider the following program
     * What are the local variables?
     */
    String[] grades = {"10","9","9","10"};
    class Halloween{
        String title;
        String[] pranks;

        void printPranks(int n){
            int x;

            for (int i=0; i<pranks.length; i++){
                String p = grades[i];
                x = p.length();
                if (p.length() >= n){
                    System.out.print(p+" ");
                }
                System.out.println(i);
            }
        }
    }

    /*
     * The local variables are:
     * int x, int i, String p
     */
    public static void main(String[] args) {
    }
}
