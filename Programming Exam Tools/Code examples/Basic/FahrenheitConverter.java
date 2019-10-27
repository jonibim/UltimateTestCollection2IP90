import java.util.Scanner;
import java.util.Locale;

/** 
 * Fahrenheit to Celsius converter
 *
 * TC stands for Teacher Comment
 */
class FahrenheitConverter {
  Scanner scn = new Scanner(System.in);
  
  /**
   * Converts Celsuis to Fahrenheit
   */
  void convert() {
    scn.useLocale(Locale.US);
    
    System.out.println("Give a temperature in degrees Fahrenheit");
    double tempInFahrenheit = scn.nextDouble();
    
    double tempInCelsius = ((tempInFahrenheit - 32) * 5) / 9; //TC: tempInFahrenheit double, so double's / used
    System.out.println(tempInFahrenheit + " degrees Fahrenheit = " + tempInCelsius + " degrees Celsius");
  }
  
  // TC: Start-up code
  public static void main(String... args) {
    new FahrenheitConverter().convert();
  }
}