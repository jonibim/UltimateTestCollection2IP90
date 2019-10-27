public class UpsideDown {

    String reverse(String s){
        String tmp = "";
        if (s.length()==0){
            return "";
        }
        if (s.length()==1){
            return s;
        }

        tmp = s.substring(s.length()-1,s.length());

        return tmp+reverse(s.substring(0,s.length()-1));
    }

    boolean isPalindrome(String s){
        if (s.equals(reverse(s))){
            return true;
        }
        return false;
    }

    void upsideDown(String[] text){
        for (int i = text.length-1; i >= 0; i--) {
            System.out.println(reverse(text[i]));
        }
    }

    void run(){
        String[] arr = {"madam", "I'm", "adam"};
        System.out.println(reverse("adfl"));
        upsideDown(arr);
    }

    public static void main(String[] args) {
        new UpsideDown().run();
    }
}
