public class Exercise3 {

    //broken code
    /*
    String reverse(String s) {
        if (s==""){
            return "";
        } else {
            return s.substring(s.length-1, s.length)
                    +  reverse(s);
        }
    }
     */

    static String reverse(String s) {
        if (s.equals("")){             //This needs to be written as equals()
            return "";
        } else {
            String d = s.substring(s.length()-1,s.length());
            return s.substring(s.length()-1,s.length())
                    +  reverse(s.substring(0,s.length()-1)); //The return kept calling itself
        }
    }

    public static void main(String[] args){
        String d = "Alohab";
        System.out.println(reverse(d));
    }
}
