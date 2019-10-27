class Folder {

  public void demo() {
    int[] a = new int[] {1,2,3,4};
    
    // ADD MORE CODE HERE TO DEMONSTRATE 
  }
  
  // ADD FOLD METHOD HERE
  
  public static void main(String[] args) {
    Folder fld = new Folder();
    fld.demo();
  }
}

interface BinaryOperator {
  public int apply(int a, int b);
  public int neutralElement();
}

class Plus implements BinaryOperator {
  public int apply(int a, int b) {
    return -1; // REPLACE WITH THE CORRECT CODE
  }
  
  public int neutralElement() {
    return -1; // REPLACE WITH THE CORRECT CODE
  }
}

// ADD MORE BINARY OPERATOR CLASSES HERE
