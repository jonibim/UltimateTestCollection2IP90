import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

class Kaprekar {
    private int n;
    private final int MAX_DIGITS = 4;
    private int[] kaprekarN = new int[MAX_DIGITS];
    private Scanner scn = new Scanner(System.in);

    
    int[] int2array(int n) {
        for(int i = 0; i < MAX_DIGITS; i++) {
            if (i == 0) {
                kaprekarN[i] = n % 10;
            } else if (i == 1) {
                kaprekarN[i] = (n / 10) % 10;
            } else if (i == 2) {
                kaprekarN[i] = (n / 100) % 10;
            } else if (i == 3) {
                kaprekarN[i] = (n / 1000) % 10;
            }
            
        }
        return kaprekarN;
    }
    
    int array2int(int[] a) {
        int n = 0;
        for(int i = 0; i < MAX_DIGITS; i++) {
            if (i == 0) {
                n = a[i] * 1000;
            } else if (i == 1) {
                n += a[i] * 100;
            } else if (i == 2) {
                n += a[i] * 10;
            } else if (i == 3) {
                n += a[i];
            }
        }
        return n;
    }
    
    int[] reverseArray(int[] a) {
        for (int i = MAX_DIGITS - 1; i >= 0; i--) {
            kaprekarN[i] = a[MAX_DIGITS - i - 1];
        }
        return kaprekarN;
    }
    
    int nextKaprekar(int n) {
        int nSmall;
        int nBigg;
        kaprekarN = int2array(n);
        Arrays.sort(kaprekarN);
        nSmall = array2int(kaprekarN);
        System.out.println(nSmall);
        int[] reverse = reverseArray(kaprekarN);
        nBigg = array2int(reverse);
        System.out.println(nBigg);
        System.out.print("" + nBigg + " - " + nSmall);
        return nBigg - nSmall;
    }
    
    void doKaprekar() {
        int n = scn.nextInt();
        System.out.println(" = " + nextKaprekar(n));        
    }
    
    public static void main(String... args) {
        Kaprekar kaprekar = new Kaprekar();
        kaprekar.doKaprekar();
    }
}