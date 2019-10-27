public class Exercise4 {
    static void make() {
        int count = 0;
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                System.out.println(count += 1);
            }
        }
    }

    public static void main(String[] args) {
        make();
    }
}

/* How many calles are made in the loops?
* In the loops we have 15 calls
* i = 0
* j = 0
* 0
* 1
* 2
* 3
* 4
* i = 1
* j = 1
* 1
* 2
* 3
* 4
* j = 2
* 2
* 3
* 4
* j = 3
* 3
* 4
* j = 4
* 4
 */
