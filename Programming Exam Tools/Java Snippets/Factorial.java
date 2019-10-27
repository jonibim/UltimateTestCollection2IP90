public static int factorial(int number) {
    int result = 1;
    for (int factor = 2; factor <= number; factor++) {
        result *= factor;
    }
    return result;
}