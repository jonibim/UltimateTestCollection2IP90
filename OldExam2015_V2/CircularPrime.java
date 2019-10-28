public class CircularPrime {

    boolean isPrime(int n) {
        if (n <= 0) {
            System.out.println("It is not a valid number");
            return false;
        }

        if (n == 1) {
            System.out.println("1 is not a prime number by definiton)");
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Other Solution
    /*
    int largestPowerOfTen(int n){
        if(n==0){
            return 0;
        }
        if(n<9){
            return 1;
        }
        int index=1;
        while (true){
            if(n%Math.pow(10,index)==n){
                return (int) Math.pow(10,index-1);
            }
            index++;
        }
    }

     */

    //Best Solution
    int largestPowerOfTen(int n) {
        return (int) Math.pow(10, Math.floor(Math.log10(n)));
    }

    boolean isCircularPrimeLOL(int n) {
        if (!isPrime(n)) {
            return false;
        }
        int nrTemp = n;
        do {
            nrTemp = nrTemp % 10 * largestPowerOfTen(n) + nrTemp / 10;
            if (!isPrime(nrTemp))
                return false;
        }
        while (nrTemp != n);
        return true;
    }

    boolean isCircularPrime(int n) {
        if (!isPrime(n)) {
            return false;
        }
        int nrTemp = n;
        do {
            if (!isPrime(((nrTemp / 10) + (nrTemp % 10) * largestPowerOfTen(nrTemp)))) {
                return false;
            }
            nrTemp = ((nrTemp / 10) + (nrTemp % 10) * largestPowerOfTen(nrTemp));
        }
        while (nrTemp != n);
        return true;
    }

    void run() {
        System.out.println(isPrime(2));
        System.out.println(largestPowerOfTen(100));
        System.out.println(isCircularPrime(13));
    }

    public static void main(String[] args) {
        new CircularPrime().run();
    }
}
