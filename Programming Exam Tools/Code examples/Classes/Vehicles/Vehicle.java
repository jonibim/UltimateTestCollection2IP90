/**
 * Base class for all different Vehicles
 */
class Vehicle {

  int registrationNumber; // TC: All vehicles have a registration number and weight
  int weight;

  public Vehicle(int registrationNumber, int weight) {
    // TC: Use 'this' to distinguish between the instance variable 'registrationNumber' and the constructor parameter 'registrationNumber'.
    // TC: The 'this.registrationNumber' points to the instance variable
    this.registrationNumber = registrationNumber;
    // TC: Same as above but then for the weight variable
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Vehicle with reg.nr. " + registrationNumber + "\n"  // TC: \n is the control character for 'new line'
      + "Weight: " + weight; // TC: Strings using concatination (+ operator) can be spread out over multiple lines
  }

}