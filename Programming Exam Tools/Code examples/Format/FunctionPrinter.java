import java.util.Scanner;

/** 
 * Function manipulations and display 
 *
 * TC stands for Teacher Comment
 */
class FunctionPrinter {
  Scanner scn = new Scanner(System.in);
  
  // The instance variables used in the last part of the exercise
  double a;
  double b;
  double c;
  
  /**
   * Computes x^2 - 2x - 3 directly
   */
  double f1(double x) {
    return x*x - 2*x - 3;
  }
  
  /**
   * Prints table of f1(x)'s values for several values of x
   */
  void printTable1() { 
    
    System.out.println(String.format("%10s %10s", "x", "f1(x)")); 
    System.out.println("---------------------"); 
    
    for (double x = -3; x < 3; x += .5) { 
      System.out.println(String.format("%10.2f %10.2f", x, f1(x))); 
    } 
  }
  
  /**
   * Computes x^2 - 2x - 3 via function with all values parameterized (same as f1(double x))
   */
  double f(double x) {
    return f(x, 1, -2,- 3);
  }
  
  /**
   * Computes ax^2 + bx + c with all values parameters
   */
  double f(double x, double a, double b, double c) {
    // Calculate the polynominal using the method parameters
    return a*x*x + b*x + c;
  }
  
  /**
   * Prints table of f(x)'s values for several values of x 
   */ 
  void printTable2() { 
    double a; // local variables, for use in f(double x, double a, double b, double c) 
    double b; 
    double c; 
    
    System.out.println("Give a value for a:"); 
    a = scn.nextDouble(); 
    
    System.out.println("Give a value for b:"); 
    b = scn.nextDouble(); 
    
    System.out.println("Give a value for c:"); 
    c = scn.nextDouble(); 
    
    System.out.println(String.format("%10s %10s", "x", "f(x, a, b, c)")); 
    System.out.println("---------------------"); 
    
    for (double x = -3; x < 3; x += .5) { 
      System.out.println(String.format("%10.2f %10.2f", x, f(x, a, b, c))); 
    } 
  }  
  
  /**
   * Computes ax^2 + bx + c with a, b and c instance variables
   */
  double fInst(double x) {
    // Calculate the polynominal using the instance variables
    return a*x*x + b*x + c;
  }
  
  /**
   * Prints table of f(x)'s values for several values of x 
   */
  void printTable3() { 
    System.out.println("Give a value for a:"); 
    a = scn.nextDouble(); 
 
    System.out.println("Give a value for b:"); 
    b = scn.nextDouble(); 
 
    System.out.println("Give a value for c:"); 
    c = scn.nextDouble(); 
     
    System.out.println(String.format("%10s %10s", "x", "fInst(x)")); 
    System.out.println("---------------------"); 
     
    for (double x = -3; x < 3; x += .5) { 
      System.out.println(String.format("%10.2f %10.2f", x, fInst(x))); 
    } 
  }
  
  /**
   * Game to guess points where function is 0
   */
  void playGuessingGame() {
    double lastResult = 1.;
    double threshold = 0.001;
    int nrOfGuesses = 0;
    boolean closeEnough = false;
    
    while (!closeEnough) {
      System.out.println("Guess an x value");
      
      double guessedX = scn.nextDouble();
      lastResult = f(guessedX);
      nrOfGuesses += 1;
      
      System.out.println(String.format("f(%.4f) = %.4f.", guessedX, lastResult));
      
      if (lastResult < threshold && lastResult > -threshold) {
        System.out.println(String.format("Close enough. You had to guess %d times.", nrOfGuesses));
        closeEnough = true;
      } else {
        System.out.println("You can do better");
      }
    }
  }
  
  /**
   * Demo's functions 
   */ 
  void run() {
    printTable1();
    printTable2();
    printTable3();
    playGuessingGame();
  }
  
  public static void main(String[] args) {
    new FunctionPrinter().run();
  }
}