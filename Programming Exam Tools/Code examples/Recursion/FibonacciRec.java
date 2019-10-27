import java.util.Scanner;

/**
 * Calculate Fibonacci with recursion
 */
class FibonacciRec {
  Scanner scn = new Scanner(System.in);
  int numberOffCalls; // counts calls TC instance variable, as count must be preserved over calls
  
  int fib(int n) {
    numberOffCalls ++; //TC: as calls must be counted, make that first action of fib

    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fib(n-2) + fib(n-1);
    }
  }
   
  void calculate() {
    numberOffCalls = 0; //initialze numberOffCalls 
        
    System.out.println("For which number do you want to calculate fibonacci?");
     int n = scn.nextInt();
     
     int answer = fib(n);
     
     System.out.printf("Fibonacci for %d is %d\n", n, answer); 
  }
  
  public static void main(String[] args) {
    FibonacciRec fib = new FibonacciRec();
    fib.calculate();
  }
}