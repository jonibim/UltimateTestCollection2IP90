import java.util.Scanner;

public class Exercise1 {
    Scanner scanner = new Scanner(System.in);
    void run(){
        int height;
        int width;
        height = scanner.nextInt();
        width = scanner.nextInt();
        int[][] sheet = new int[height][width];
        for (int r = 0; r < height; r++){
            for (int c = 0; c < width; c++){
                sheet[r][c] = scanner.nextInt();
            }
        }
    }

}


/* Find the local variables
Definition the local variables are the variables which are accsessible only inside a method
they cannot be accsessed outside the method, in our case we have 5 local variables which are
 * height
 * width
 * sheet
 * r
 * c
 */
