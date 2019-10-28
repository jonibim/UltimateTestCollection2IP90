public class Reversal {

    /*
    Submit your code in a file named Reversal.java
    Write a recursive method String reverse(String s) that returns the reversal of the String s. No
    loops are allowed.
    Examples:
    reverse("papetrog") returns "gortepap";
    reverse("") returns "" (the empty String);
    reverse("parterretrap") returns "parterretrap"
    Some of the following operations on strings may be helpful (you probably don’t need them all). In all
    the examples below, assume that alfa is the String "abcd".
    s.substring(start) returns the tail of s, starting with the character at position start; e.g.,
    alfa.substring(1) returns "bcd".
    s.substring(start, end) returns the substring of s that starts at position start and ends at
    end-1; e.g., alfa.substring(1,3) returns "bc".
    s.charAt(n) returns the character at position n in String s; e.g., alfa.charAt(3) returns ’d’.
    s.length() (not s.length !) gives the number of characters in String s, e.g., alfa.length()
    returns 4.
     */

    String reverse(String s) {
        String newString = "";
        if (s.length() == 0) {
            return "";
        }
        newString = s.substring(s.length() - 1, s.length());
        return newString + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(new Reversal().reverse("taerg did u"));
    }
}
