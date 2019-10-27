import java.util.Scanner;
import java.util.Locale; //TC: provides decimal point INPUT adaption (output remains with ,)

/** 
 * Repeated temperature converter  
 *
 * TC stands for Teacher Comment
 */
class TemperatureConverter {
  Scanner scn = new Scanner(System.in);
  
  /**
   * Converts temperatures
   */
  void convert() {
    scn.useLocale(Locale.US); //TC: enables to use decimal point in input

    System.out.println("Give a temperature in Celsius or Fahrenheit or type q to quit"); 
    
    while (scn.hasNextDouble()) { //TC: checks input for being a double but does not input value
      double temp = scn.nextDouble();
      String choice = scn.next();
      
      double celsius;
      double fahrenheit;
      
      if ("c".equals(choice.toLowerCase())) { //TC: equals for String comparison, not ==
        celsius = temp; //TC: now temp(erature) value put in celsius, for clarity of formula and output
        fahrenheit = celsius * 1.8 + 32;
        System.out.println(String.format("%.1f degrees Celsius = %.1f degrees Fahrenheit",celsius,fahrenheit));
      } else if ("f".equals(choice.toLowerCase())) {
        fahrenheit = temp; //TC: now temp(erature) value put in fahrenheit, for clarity of formula and output
        celsius = (fahrenheit - 32) / 1.8;
        System.out.println(String.format("%.1f degrees Fahrenheit = %.1f degrees Celsius",fahrenheit,celsius));
      } else {
        System.out.println("I don't know what to convert :s");
      }
     
    }
  }
  
  public static void main(String... args) {
    new TemperatureConverter().convert();
  }
}