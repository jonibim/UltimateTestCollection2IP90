//
//class A extends B{}
//
//class B {}

class ExamTester {
    
//    static A a;
//    
//    void m(B b) {}
//    
//    void print() {
//        System.out.println("Hello");
//    }
    
    IllegalSegment is;
    
    double segsum(double[] a, int from, int to) {
        double sum = 0;

        for (int x = from; x < to; x++) {
            sum = sum + a[x];
        }
        return sum;
    }
    
    double segsumRobust(double[] a, int from, int to){
        double sum = 0;
        
        int size = a.length;
        
        try {
           
            if (from > to || from < 0 || to < 0 || from > size || to > size) {
                throw new IllegalSegment();
            } else {
                for (int x = from; x < to; x++) {
                    sum = sum + a[x];
                }
                return sum;
            }
            
        } catch (IllegalSegment is) {
            return 404;
        }
    }
    
    public static void main(String[] args) {
        //(new ExamTest()).print(); 
        ExamTester t = new ExamTester();
        
        double[] b = {9, 8, 7, 6, 5, 4};
        
        if (t.segsumRobust(b, -1, 4) == 404) {
            System.out.print("Hello... it's me...");
        } else {
            System.out.print(t.segsumRobust(b, -1, 4));
        }
    }
}

class IllegalSegment extends Exception {
    IllegalSegment() { }
    
    IllegalSegment( String s ) {
        super( s );
    }
}  