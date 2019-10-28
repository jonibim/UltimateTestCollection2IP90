public class Misc2015V2 {

    /*
     *
     * 1.1
     * ------------------
     * True or False?
     * There can be only one method nemed foo in a class
     *
     * False.There can be many methods called foo as long as
     * they have a different signature name + parameter list.
     *
     * ==================
     *
     * 1.2
     * ------------------
     * True or False?
     * There can be only one local variable named x in a class
     *
     * False. There can be many variables x in a class
     * inside different functions
     *
     * Example below v v v v
     *
     */

    class VariableExample {
        void run() {
            int x;
        }

        void example() {
            int x;
        }

        boolean isTrue() {
            boolean x = false;
            return x;
        }
    }

    /*
     *
     *
     *
     * ===================
     *
     * 1.3
     * -------------------
     * Give two reasons why the following method may not
     * always execute the body B exactly _n_ times.
     * n is an int variable;
     * for (int i=0; i<n; i++){
     * B
     * }
     *
     *
     * Reason#1:
     * There might be a function inside the loop
     * which can change the variable i, meaning that
     * it would not cause the loop to execute the body B
     * exactly n times
     *
     * Reason#2:
     * n may be an number less than 0
     *
     * ==========================
     *
     * 1.4
     * -------------------------
     * What is the number of objects(instances) of class
     * C created by the following method?
     */

    class C {
        void create() {
            int n;
            C aap;
            C noot;
            C[] someCs;
            n = 3;
            someCs = new C[n];
        }
    }

    /*
     * The number of objects of class C created
     * is ZERO
     */

}
