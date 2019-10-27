/**
 * >number and name of assignment< -- 2ip90 >what is this? i.e. main class<
 * 
 * @author Buster Franken student number: 0912005, s148029
 * 
 */

public class Exersize2 {

    int digitSum(int n) {

        // from exersize 2.1 but now without instance variable
        if (n < 10) {
            return n;
        } else {
            // make b equal to the last digit of the number + the digitSum return of everything before that
            n = n % 10 + digitSum(n / 10);
            System.out.print("here we are!");
        }
        return n;
    }

    int digitalRoot(int n) {
        // keeps running digitSum until a single digit value comes out, then returns
            while (n > 10) {
                n = digitSum(n);
            }
        return n;
    }

    // method of 2.3
    String reverse(int n){
        // converts the integer to a String
        String str = Integer.toString(n);
        String reverse = "";
        
        for(int i = str.length() - 1; i >= 0; i--){
            reverse = reverse + str.charAt(i);
        }

        return reverse;
    }

    public static void main(String[] args) {
        int a = 193;

        Exersize2 setup = new Exersize2();

        // prints out result
        // System.out.print(setup.digitalRoot(a));  // from ex. 2.2
        // System.out.print(setup.digitSum(a));  // from ex. 2.1
        System.out.print(setup.reverse(a));
    }
}