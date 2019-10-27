import java.util.Arrays;

public class ArrayFun {
    double sum(double[] a) {
        int sum=0;
        if (a.length==0){
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    double[] colsum(double[][] m) {
        double sum[] = new double[m.length];
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[0].length ; j++) {
                sum[i] += m[i][j];
            }
        }
        return sum;
    }

    int segsum(int[] a, int from, int upto) {
        int sum=0;
        if (a.length==0 || upto == 0){
            return 0;
        }
        if (from == upto-1){
            return sum=+a[from];
        }
        sum+=a[from];
        return segsum(a, from+1, upto)+sum; //change this
    }

    void demo() {
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {-1, -2, -3},
                {2, 4, 6}
        };
        double[] result = colsum(matrix);
        System.out.println(Arrays.toString(result));
        int[] segsumA = {1,2,3,4};
        System.out.println(segsum(segsumA,0,0));
    }

    public static void main(String[] args) {
        new ArrayFun().demo();
    }
}
