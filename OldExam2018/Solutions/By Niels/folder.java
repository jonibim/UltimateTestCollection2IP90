/* Folder.java
 * @author Niels Gorter
 * @id 1332678
 * @date: 30/10/2018
 */

class Folder {
    
    public void demo() {
        int[] a = new int[] {1,2,3,4};
        // ADD MORE CODE HERE TO DEMONSTRATE
        System.out.println(fold(a, new Plus()));
        System.out.println(fold(a, new Times()));
        System.out.println(fold(a, new Max()));
    }
    
    // ADD FOLD METHOD HERE
    //Applies the given binary operator for all integers in the array
    int fold(int[] a, BinaryOperator op) {
        
        int result = op.neutralElement();
        for (int aa : a) {
            result = op.apply(result, aa);
        }
        return result;
    }    
    
    public static void main(String[] args) {
        Folder fld = new Folder();
        fld.demo();
    }
}

interface BinaryOperator {
    public int apply(int a, int b);
    public int neutralElement();
}

/*
 * Operator that gives the sum of the given integers
 */
class Plus implements BinaryOperator {
    public int apply(int a, int b) {
        return a + b;
    }
    
    //sets neutralElement to 0, as all numbers plus 0 are themselves
    public int neutralElement() {
        return 0;
    }
}

// ADD MORE BINARY OPERATOR CLASSES HERE

/*
 * Operator that gives the product of the given integers
 */
class Times implements BinaryOperator {
    public int apply(int a, int b) {
        return a * b;
    }
    
    //sets neutralElement to 1, as all numbers times 1 are themselves
    public int neutralElement() {
        return 1;
    }
}

/*
 * Operator that gives the maximal integer of the given integers 
 */
class Max implements BinaryOperator {
    public int apply(int a, int b) {
        return Math.max(a, b);
    }
    
    //sets neutralElement to lowest possible int
    public int neutralElement() {
        return Integer.MIN_VALUE;
    }
}