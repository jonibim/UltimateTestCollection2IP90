/**
 * Class that represents a Car.
 */
class Car extends Vehicle { // TC: Car inherits from Vehicle and is a subclass of Vehicle
  // TC: Since Car inherits from Vehicle it also inherits the instance variables registrationNumber and weight
  String fuelType; // TC: Next to the registrationNumber and weight a Car has a fuelType

  public Car(int registrationNumber, int weight, String fuelType) {
    super(registrationNumber, weight); // TC: Constructors are not inherited. 
    // TC: Since Vehicle only has one constructor (with 2 parameters) there must a an explicit call to this constructor using 'super(_,_)'
    this.fuelType = fuelType;
  }

  @Override
  public String toString() {
    return super.toString() + "\n" // TC: Extend the toString() implementation of the Vehicle.toString() (using super.toString())
      + "Vehicle type: Car\n"  // TC: Add the vehicle type and fuel type to the result
      + "Fuel type: " + fuelType;
  }
}