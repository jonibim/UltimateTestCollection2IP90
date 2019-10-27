public class GettingDigital {
    int digitSum(int n){
        if (n==0){
            return 0;
        }
        return digitSum(n/10)+n%10;
    }

/*  //Redundant code. Don't mind this...
    int countDigit(int n){
        int count=0;
        if (n==0){
            return 0;
        }
        count+=1;
        return countDigit(n/10)+count;
    }
*/

    int findMax(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.max(n % 10, findMax(n / 10));
    }

    int dropMax(int n){
        int dMax=findMax(n);
        if (n==0){
            return 0;
        }
        if (n%10==dMax){
            return n/10;
        }
        return 10*dropMax(n/10)+n%10;
    }

    int digitalRoot(int n){
        if (n==0){
            return n;
        }
        if (digitSum(n)<9){
            return (digitSum(n));
        }
        return digitalRoot(dropMax(n));

    }


    //Stupid solution #1 which you probably won't understand (I don't lol)
    String reverse(int n){
        String reverse = new StringBuilder(n+"").reverse().toString();
        return reverse;
    }

    //Solution Proper #1
    //What we do is this stupid trick    100 -> 0  10 -> 0 0 1
    String reverse2(int n){
        if(n<10) {
            return String.valueOf(n);
        }
        return String.valueOf(n%10) + reverse3(n/10);
    }

    //Solution GodLike (same as Proper #1 but written beautifully)
    String reverse3(int n){
        return n < 10 ? String.valueOf(n) : String.valueOf(n%10) + reverse3(n/10);
    }

    void demo(){
        System.out.println(100/100);
        System.out.println(digitSum(193));
        //System.out.println(countDigit(193));
        System.out.println(digitalRoot(19833));
        //System.out.println(recursion(19833));
        System.out.println(reverse(100));
        System.out.println(reverse3(100));
    }

    public static void main(String[] args) {
        GettingDigital d = new GettingDigital();
        d.demo();
    }
}
