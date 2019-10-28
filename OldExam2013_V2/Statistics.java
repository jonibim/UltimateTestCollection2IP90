import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Statistics {
    double sum(double[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    double mean(double[] a) {
        return sum(a) / a.length;
    }

    int max(int[] a, int i) {
        if (a.length == 0 || i == a.length - 1) {
            return 0;
        }
        return Math.max(a[i], max(a, i + 1));
    }

    int[] prio(int[] a) {
        int newArr[] = a.clone();
        newArr[0] = max(newArr, 0);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == newArr[0]) {
                newArr[i] = a[0];
                break;
            }
        }
        return newArr;
    }

    void run() {
        int test[] = {1, 2, 3, 55, 9};
        System.out.println();
        System.out.println(max(test, 0));
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        int[] test2 = prio(test);
        System.out.println();
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Statistics().run();
    }
}
