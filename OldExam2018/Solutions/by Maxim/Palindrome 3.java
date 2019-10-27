class Palindrome {
    
    String reverse(String s) {
        
        int a = s.length();
        
        if (a <= 1) {
            return s;
        } else {
            return s.substring(a - 1, a) + reverse(s.substring(0, a - 1));
        }
    }
    
    boolean isPalindrome(String s) {
        if (s.equals(reverse(s))) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        
        System.out.println(p.isPalindrome("parterretrap"));
    }
}
