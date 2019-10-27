import java.util.concurrent.BrokenBarrierException;

public class People {

    /*
     *
     *  Which of the following class declarations correspond
     *  to this class structure?
     *
        (a) class Scotsman
        (b) class Londoner extends Englishman
        ----> class Human
        (d) class German extends Human
        *
        *
        2. Suppose all classes are declared
        * according to the diagram above.
        * Which of the following statements
        * are correct Java?
        *
        ----> Londoner lo = new Londoner();
        (b) Scotsman s = new Human();
        ----> European eur = new Dutchman();
        ----> Englishman eng = new Yorksman();
        (e) European eu = new British();
        ----> Human h = new Scotsman();
     *
     */

    static class A extends B{}
    static class B {}
    static void run(B b){ }
    public static void main(String[] args) {
        A a = new A();
        run(a);
    }
}
