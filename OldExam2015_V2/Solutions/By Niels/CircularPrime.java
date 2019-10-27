/**
 * Circular Prime -- solution to exercise 2 of exam 2ip90 of 20 January 2015
 * @author Huub vd Wetering
 * 
* A circular prime is a prime* for any rotation of its digits: For example:
* a.  37 is a circular prime, since 37 and 73 are prime. 
* b. 113 is a circular prime, since 113, 131, and 311 are prime.
* c. 907 is prime but not a circular prime, since 790 is not prime.
*
* (*A prime number is a number that is only divisible by it self and one. E.g. 7,
* 43, and 101. But not 27, since 27 is also divisible by 3 and 9.)
*
* NOTE THAT FOR THIS EXERCISE ONLY INTEGER COMPUTATIONS ARE ALLOWED!
*
*/
public class CircularPrime {
    /** Exercise 2.1: write a method with header boolean isPrime(int n) that returns
     * whether or not n is prime.
     */
    public boolean isPrime(int p) {
        for(int d=2;d<p;d++) {
            if (p%d==0) return false;
        }
        return true;
    }
    
    /** Exercise 2.2: write a method with header int largestPowerOfTen(int n), that computes
     * the largest power of 10  less or equal to n. 
     * E.g. n=82 gives 10, n=100 gives 100, and n=2015 gives 1000. 
     */
    private int largestPowerOfTen(int n) {
        int p=1;
        while (n/10>0) {
            n = n/10;
            p=p*10;
        }
        return p;
    }
    
    /** Exercise 2.3: write a method with header boolean isCircularPrime(int n) that
     * returns whether or not n is a circular prime. 
     * Use the methods from exercises A and B.
     */
    private boolean isCircularPrime(final int n) {
        int m = n;
        int p = largestPowerOfTen(n);  // Note don't apply this in loop to m
        do {
            if (!isPrime(m)) return false;
            m = (m%p)*10+(m/p); // circular rotation of the number to the left
        } while(m!=n);
        return true;
    }
    
    /** Exercise 2.4: Write code in the main method to compute all circular primes
     *              larger than 1 and smaller than 1000.
     **/
    public static void main(String[] args) {
        (new CircularPrime()).allCircularPrimesBelow1000();
    }
    
    public void allCircularPrimesBelow1000() {
        for(int n=2;n<1000;n++) {
            if (isCircularPrime(n)) {
                System.err.println(n);
            }
        }
    }
    
    
    /** alternative solution, only valid for numbers under 1000. **/
    private boolean isCircularPrime2(int n) {
        if (!isPrime(n)) {
            return false;
        } else if (n<10) {
            return true;
        } else if (n<100) {
            int d0=n%10; int d1=(n-d0)/10;
            return isPrime(d0*10+d1);
        } else if (n<1000) {
            int d0=n%10; int d1=(n%100-d0)/10; int d2 = (n-d1*10-d0)/100;
            return isPrime(100*d1+10*d0+d2) && isPrime(100*d0+10*d2+d1);
        }
        return false;
    }
}