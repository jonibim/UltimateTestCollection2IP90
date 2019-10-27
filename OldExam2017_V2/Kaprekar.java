import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;

public class Kaprekar {

    Scanner sc = new Scanner(System.in);

    int countDigit(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        }
        count += 1;
        return countDigit(n / 10) + count;
    }

    int[] int2array(int n) {
        int SIZE = 0;
        if (countDigit(n) < 4) {
            SIZE = 4;
        } else {
            SIZE = countDigit(n);
        }

        int[] digits = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }


    int array2int(int[] n) {
        int number = 0;
        if (n.length == 0) {
            return 0;
        }
        for (int i = 0; i < n.length; i++) {
            number += n[i] * Math.pow(10, i);
        }
        return number;
    }

    int nextKaprekar(int n) {
        int[] ascending = int2array(n);
        Arrays.sort(ascending);
        int indexOf = ascending.length - 1;
        int[] descending = new int[ascending.length];
        for (int i = 0; i < ascending.length; i++) {
            descending[i] = ascending[indexOf];
            indexOf--;
        }
        int ascNumber = array2int(ascending);
        int desNumber = array2int(descending);
        int resultNumber = ascNumber - desNumber;
        System.out.println(ascNumber + " - " + desNumber + " = " + resultNumber);
        return resultNumber;
    }

    void doKaprekar() {
        System.out.print("Enter Number for Kaprekan Procedure: ");
        int _number = sc.nextInt();
        if (_number < 0) {
            System.out.println("Enter a positive number");
        } else {
            int result = -1;
            int kaprekarNumber = 0;
            while (kaprekarNumber != result) {
                kaprekarNumber = nextKaprekar(_number);
                result = _number;
                _number = kaprekarNumber;
            }
            System.out.println("======END======");

        }


    }

    public static void main(String[] args) {
        new Kaprekar().doKaprekar();
    }

}
