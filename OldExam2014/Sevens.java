public class Sevens {
    int lastDigit(int n){
        return n%10;
    }

    int chop(int n){
        return n/10;
    }
    int sevencount(int n){
        int count=0;
        if (n==0){
            return 0;
        }
        if (lastDigit(n)==7){
            count+=1;
        }

        return sevencount(chop(n))+count;
    }
    int drop7(int n){

        if (n==0){
            return 0;
        }

        if(lastDigit(n)==7){
            return drop7(chop(n));
        }

        return 10*drop7(chop(n)) + lastDigit(n);
    }

    void run(){
        System.out.println(drop7(2717));
    }

    public static void main(String[] args) {
        Sevens s = new Sevens();
        s.run();
    }


}
