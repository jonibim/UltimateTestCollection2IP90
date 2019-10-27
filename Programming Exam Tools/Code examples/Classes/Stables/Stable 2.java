/**
 * Model of stable with animals eating from re-allocatable troughs
 */
class Stable {
  Animal[] animals;
  Trough[] troughs;
  
  void farm() {
    animals = new Animal[3];
    troughs = new Trough[2];
    
    for (int i = 0; i < animals.length; i++) {
      animals[i] = new Animal();
    }
    
    for (int i = 0; i < troughs.length; i++) {
      troughs[i] = new Trough();
    }
    
    animals[0].setTrough(troughs[0]);
    animals[1].setTrough(troughs[0]); // TC: makes second animal in array eat from trough of first
    animals[2].setTrough(troughs[1]);
    
    fillAllTroughs(3);
    letAllAnimalsEat(); //TC: first and second animal eat from same trough
    letAllAnimalsEat();
  }
  
  void fillAllTroughs(int nrOfMeals) {
    for (int i = 0; i < troughs.length; i++) {
      troughs[i].fill(nrOfMeals);
    }
  }
  
  void letAllAnimalsEat() {
    for (int i = 0; i < animals.length; i++) {
      animals[i].eat();
    }
  }
  
  public static void main(String[] args) {
    Stable stable = new Stable();
    stable.farm();
  }
}

class Animal {
  int stomach;   // number of meals
  Trough trough; // the trough of this animal
  
  Trough getTrough() { //TC: enables farmer to get trough address
    return trough;
  } 
  
  void setTrough(Trough t) { //TC: enables farmer to set trough adress
    this.trough = t;
  }
  
  void eat() {
    int meal = trough.give();
    stomach = stomach + meal;
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
}