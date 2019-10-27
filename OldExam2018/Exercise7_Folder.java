public class Exercise7_Folder {
    public void demo() {
        int[] a = new int[] {1,2,3,4};
        System.out.println(fold(a,new Plus()));
        System.out.println(fold(a,new Times()));
        System.out.println(fold(a,new Max()));
    }

    public int fold(int[] a, BinaryOperator op){
        int result=op.neutralElement();
        for (int i=0; i<a.length; i++){
            result=op.apply(result,a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Exercise7_Folder fld = new Exercise7_Folder();
        fld.demo();
    }
}

interface BinaryOperator {
    public int apply(int a, int b);
    public int neutralElement();
}

class Plus implements BinaryOperator {
    public int apply(int a, int b) {
        return a+b;
    }

    public int neutralElement() {
        return 0;
    }
}
class Times implements BinaryOperator {
    public int apply(int a, int b) {
        return a*b;
    }

    public int neutralElement() {
        return 1;
    }
}
class Max implements BinaryOperator {
    public int apply(int a, int b) {
        int max=Integer.MIN_VALUE;
        if (a>max){
            max=a;
        }
        if (b>max){
            max=b;
        }
        return max;
    }

    public int neutralElement() {
        return 0;
    }
}
