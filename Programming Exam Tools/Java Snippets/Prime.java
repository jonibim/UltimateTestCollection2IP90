public static boolean isPrime(int number) {
    if (number < 3) {
        return true;
    }
    // check if n is a multiple of 2
    if (number % 2 == 0) {
        return false;
    }
    // if not, then just check the odds
    for (int i = 3; i * i <= number; i += 2) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}