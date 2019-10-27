/**
 * Class that represents a Truck
 */
class Truck extends Vehicle {
  // TC: Although no instance variables are declared Truck still has the inherited variables registrationNumber and weight
  
  Truck(int registrationNumber, int weight) {
    super(registrationNumber, weight); // TC: Since constructors are not inherited and Vehicle only has one constructor with 2 parameters we must add this constructor here
  }
  
  @Override
  public String toString() {
    return super.toString() + "\n" + // TC: Extend the toString() implementation of the Vehicle.toString() (using super.toString())
      "Vehicle type: Truck\n";
  } 
}