class Miscellaneous {
    /*
     * 1.1
     * false. There can be multiple methods called donald, if they have different parameters.
     * e.g.
     * donald() {}
     * donald(int n) {}
     * donald(String string) {}
     */

    /*
     * 1.2
     * class A extends B {}
     * class B {}
     * A a = new A();
     */

    /*
     * 1.3
     */
    double segsum(double[] a, int from, int to) {
        double sum = 0;

        for (int x = from; x < to; x++) {
            sum = sum + a[x];
        }
        return sum;
    }


    /*
     * 1.4
     */
    double segsumRobust(double[] a, int from, int to) throws IllegalSegment{
        double sum = 0;

        if (from < 0 || from > a.length || from > to || to > a.length) {
            throw new IllegalSegment();
        }

        for (int i = from; i < to; i++) {
            sum += a[i];
        }

        return sum;
    }

    /*
     * 1.5
     * int x, int i, String p
     */
}

class IllegalSegment extends Exception {
    IllegalSegment() { }

    IllegalSegment( String s ) {
        super( s );
    }
}  