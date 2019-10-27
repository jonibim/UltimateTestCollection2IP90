public class Starts {

    static void printStarts(int width, int height, boolean filled){
        for (int i=0; i<height; i++){
            for (int j=0; j<width;j++){
                if (filled){
                    System.out.print("* ");
                }
                else{
                    if ((j>=1 && j<width-1) && (i>=1 && i<height-1) ){
                        System.out.print("  ");
                    }else{
                        System.out.print("* ");
                    }
                }
            }
            System.out.println();
        }
    }

    static void barChart(int [] values){
        for (int i=0; i<values.length;i++){
            for (int j=0; j<values[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printStarts(5,5,false);
        int[] test = {3,4,5,6,0,3};
        barChart(test);
    }
}
