/**
 * Class that collects and prints the vehicle information
 */
class VehicleAdministration { 
  
  Vehicle[] vehicles; // TC: Since all classes extend Vehicle, they can be stored in an arry of type Vehicle
  
  void administrate() { 
    vehicles = new Vehicle[3]; 
    vehicles[0] = new Car(123, 500, "Gasoline"); 
    vehicles[1] = new Motorcycle(124, 150, true);
    vehicles[2] = new Truck(345,3000);
    
    printVehicles();   
  }
  
  void printVehicles() { 
    for ( Vehicle v : vehicles ) { 
      System.out.println( "--------------------------------" ); 
      System.out.println(v); // TC: This uses all the custom toString() methods as defined in the Car, Motorcycle and Truck classes
    } 
    
    System.out.println( "--------------------------------" ); 
  } 
  
  public static void main( String[] a ) { 
    VehicleAdministration va = new VehicleAdministration(); 
    va.administrate();
  }
}