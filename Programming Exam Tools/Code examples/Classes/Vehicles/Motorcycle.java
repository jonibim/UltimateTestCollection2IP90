/**
 * Class that represents a Motorcycle
 */
class Motorcycle extends Vehicle { // TC: Motorcycle inherits from Vehicle and is a subclass of Vehicle
  // TC: Since Motorcycle inherits from Vehicle it also inherits the instance variables registrationNumber and weight
  boolean hasSidecar; // TC: Next to the registrationNumber and weight a Motorcycle has a hasSideCar (zij-span) property

  public Motorcycle(int registrationNumber, int weight, boolean hasSidecar) {
    super(registrationNumber, weight); // TC: Constructors are not inherited. 
    // TC: Since Vehicle only has one constructor (with 2 parameters) there must a an explicit call to this constructor using 'super(_,_)'
    this.hasSidecar = hasSidecar; 
  }

  @Override
  public String toString() {
    return super.toString() + "\n" // TC: Extend the toString() implementation of the Vehicle.toString() (using super.toString())
      + "Vehicle type: Motorcycle\n" // TC: Add the vehicle type and whether or not it has a side car to the result
      + "Has sidecar: " + hasSidecar;
  }

}