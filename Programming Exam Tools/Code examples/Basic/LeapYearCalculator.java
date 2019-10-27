import java.util.Scanner;

/** 
 * Leapyear calculator 
 *
 * TC stands for Teacher Comment
 */
class LeapYearCalculator {
  Scanner scn = new Scanner(System.in);
  
  /**
   * Computes and outputs leapyear verdict
   */
  void checkLeapYear() {
    System.out.println("Type in a year");
    int year = scn.nextInt();
    
    //TC: if divisible by 4 and not by 100 or divisible by 400
    boolean isLeapYear = year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
    
    System.out.println("The statement year " + year + " is a leap year is " + isLeapYear);
  }
  
  public static void main(String... args) {
    new LeapYearCalculator().checkLeapYear(); 
  }
}