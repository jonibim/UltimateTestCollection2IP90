/** UpsideDown.java -- answer file for exam 2ip91 -- 24 January 2017
 * @author
 *    @id
 */

/* Don't make your lines longer than this one *********************************/

class UpsideDown {
    // 2.1
    String reverse(String s) {

        if (s.length() <= 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

    // 2.2
    boolean isPalindrome(String s) {
        return reverse(s).equals(s);
    }

    void upsideDown(String[] text) {
        // non-recursive (max 7 points):
        //for (int i = text.length - 1; i >= 0 ; i--) {
        //    System.out.println(reverse(text[i]));
        //}

        //recursive (more complicated but more points):
        if (text.length == 0) {
            return;
        }

        System.out.println(reverse(text[text.length - 1]));
        String[] temp = new String[text.length - 1];
        System.arraycopy(text, 0, temp, 0, text.length - 1);
        upsideDown(temp);
    }

    public static void main(String[] args) {
        UpsideDown ud = new UpsideDown();

        String[] words = {"madam", "I'm", "adam"};

        ud.upsideDown(words);

//        String test = "";
//        System.out.println(test);
//        System.out.println(ud.reverse(test));
//        System.out.println(ud.isPalindrome(test));
    }
}
