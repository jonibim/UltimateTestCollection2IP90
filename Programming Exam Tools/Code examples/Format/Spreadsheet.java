import java.util.Scanner;

/** 
 * Spreadsheet for integers addition  
 *
 * TC stands for Teacher Comment
 */
public class Spreadsheet {
  Scanner scanner = new Scanner(System.in); 
  
  void run() { 
    int height; // TC: no of rows in sheet, including row of sums         
    int width;  // TC: no of columns in sheet 
    
    // read dimensions 
    height = scanner.nextInt(); 
    width = scanner.nextInt(); 
    
    // read values 
    int[][] sheet = new int[height][width]; 
    for (int r = 0; r < sheet.length; r++) { //TC: sheet.length = height for all colums = number of rows 
      for (int c = 0; c < sheet[0].length; c++) { //TC: sheet[0].length = width for row 0 = width for all rows = number of columns
        sheet[r][c] = scanner.nextInt(); 
      } 
    } 
    
    // calculate row of sums 
    for (int c = 0; c < width; c++) { 
      int sum = 0; 
      for (int r = 0; r < height - 1; r++) { 
        sum += sheet[r][c]; 
      } 
      sheet[height-1][c] = sum; 
    } 
    
    // print sheet 
    for (int r = 0; r < sheet.length; r++) { 
      for (int c = 0; c < sheet[0].length; c++) { 
        System.out.print( String.format("%4d", sheet[r][c]) ); //TC 4 spaces width for sheet[r][c]
      } 
      System.out.println(); 
    } 
  } 
  
  public static void main(String[] a) { 
    new Spreadsheet().run();
  }
}