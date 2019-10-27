class Digital {
    
    int digitSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return n%10 + digitSum(n / 10);
        }
    }  
    
    int digitalRoot(int n) {
        while(n > 10) {
            n = digitSum(n);
        }
        return n;
    }
    
    String reverse(int n) {
        if (n < 10) {
            return "" + n;
        } else {
            return "" + n%10  + reverse(n/10);
        }
    }
    
    //test
    public static void main(String[] args) {
        Digital dig = new Digital();
        System.out.println(dig.reverse(193));
    }  
}