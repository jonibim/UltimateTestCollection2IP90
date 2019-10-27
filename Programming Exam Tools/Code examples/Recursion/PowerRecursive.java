class Power {
    
// assume b >= 0
    int power( int a, int b ) {
        if ( b == 0 ) {
            return 1;
        }
        else if ( b % 2 == 0 ) {
            return power( a * a, b/2 );
        }
        else {
            return a * power(a, b-1);
        }
    }
    
    public static void main(String[] a) {
        System.out.println((new Power()).power(2,3));
    }
}