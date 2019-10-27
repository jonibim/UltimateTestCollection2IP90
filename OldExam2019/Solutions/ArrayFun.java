class ArrayFun {
    double sum(double[] a) {
        double s = 0;
        for (int i=0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }
    
    //variant with foreach loop
    double sumBis(double[] a) {
        double s = 0;
        for (double n : a) {
            s += n;
        }
        return s;
    }
    
    double[] colsum(double[][] m) {
        int size = 0;
        if (m.length > 0) {
            size = m[0].length;
        }
        double sums[] = new double[size];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                sums[c] += m[r][c];
            }
        }
        return sums;
    }
    
    int segsum(int[] a, int from, int upto) {
        if (from >= upto) { // or ==
            return 0;
        } else { 
            return a[from] + segsum(a, from + 1, upto);
        }
    }
    
    void demo() {
        double[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, -2, -3},
            {2, 4, 6}
        };
    }
}