/**
 * Model of stable with animals eating from their troughs
 */
class Stable {
  Animal[] animals;
  
  /**
   * Organises farm activity
   */
  void farm() {
    animals = new Animal[3];
    
    for (int i = 0; i < animals.length; i++) {
      animals[i] = new Animal();
      
      int randomFill = (int)(Math.random() * 10.); // each trough gets filled with a random amount (between 0 and 10)
      animals[i].getTrough().fill(randomFill);
      System.out.printf("Animal #%d has %d possible servings\n", i, randomFill);
    }
    
    int nrOfFeedings = (int)(Math.random() * 5.); // each animal will eat a random nr of times (between 0 and 5)
    System.out.printf("Animals will eat %d times\n", nrOfFeedings);
    
    for (int i = 0; i < nrOfFeedings; i++) {
      for (int j = 0; j < animals.length; j++) {
        animals[j].eat();
      }
    }
    
    print();
  }
  
  void print() {
    for (int i = 0; i < animals.length; i++) {
      animals[i].print();
    }
  }
  
  public static void main(String[] args) {
    Stable stable = new Stable();
    stable.farm();
  }
}

class Animal {
  String name = "noname";
  int stomach;   // number of meals
  Trough trough; // the trough of this animal
  
  // constructor
  Animal() {
    this.trough = new Trough();
    stomach = 0;
  }
  
  Trough getTrough() {
    return trough;
  } 
  
  void eat() {
    stomach = stomach + trough.give();
  }
  
  void print() {
    System.out.printf("Animal %s has eaten %d meals.\n", name, stomach); 
    trough.print();
  }
}

class Trough {
  int contents; // number of meals
  int servings = 1;
  
  Trough() {
    this.contents = 0;
  }
  
  void fill(int m) {
    contents = contents + m;
  }
  
  int give() {
    if (contents > 0) {
      contents -= servings;
      return servings;
    } else {
      return 0;
    }
  }
  
  void print() {
    System.out.printf("The trough still has %d servings.\n", contents);
  }
}