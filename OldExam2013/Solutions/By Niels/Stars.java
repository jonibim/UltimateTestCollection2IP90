class Stars {
    
    void printRect(int width, int height, boolean filled) {
        if (filled) {
            for (int h = 0; h < height; h++) {
                String output = "";
                for (int w = 0; w < width; w++) {
                    output += "* ";
                }
                System.out.println(output);
            }
        } else {
            for (int h = 0; h < height; h++) {
                String output = "";
                for (int w = 0; w < width; w++) {
                    if (h == 0 || w == 0 || h == height-1 || w == width-1) {
                        output += "* ";
                    } else {
                        output += "  ";
                    }
                }
                System.out.println(output);
            }
        }
    }
    
    void barChart(int[] values) {
        int n;
        for (int i = 0; i < values.length; i++) {
            String output = "";
            n = values[i];
            for (int k = 0; k < n; k++) {
                output += "*";
            }
            System.out.println(output);
        }
    }
    
    //test
    public static void main(String[] args) {
        Stars test = new Stars();
        int[] a = {2, 5, 0, 4, 3};
        test.barChart(a);
    }
}