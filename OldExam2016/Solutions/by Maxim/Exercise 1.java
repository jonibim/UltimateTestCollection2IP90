/**
 * >number and name of assignment< -- 2ip90
 * >what is this? i.e. main class<
 * 
 * @author Buster Franken
 * student number: 0912005, s148029
 * 
 * date: 29_10_2018
 */

 // 1: true
 // 2: false
 // 3: f) 5
 // 5: three; aap, noot, street

public class Exersize1 {

    void sort(int[] a) {
        // the first for loop just executed the inner for loop
        // a number of times without changing anything
        // for (int i = 0; i < a.length; i++) {
          for (int j = 0; j < a.length-1; j++) {  // -1 because the postition is -1
            if (a[j] > a[j+1]) {
                int storej = a[j];
                int storejplus = a[j+1];
                // it used to overwrite a[j] before 
                // it could be assigned to a[j+1]
                a[j] = storejplus;
                a[j+1] = storej;
            }
        // }
        }
      }

    public static void main(String[] args) {
        int[] a = new int[] {1,3,2,4,6,5,7};

        Exersize1 setup = new Exersize1();
        setup.sort( a );

        // prints out the array
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
               System.out.print(", ");
            }
            System.out.print(a[i]);
         }
      }
}