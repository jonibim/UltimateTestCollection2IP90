/** UpsideDown.java -- answer file for exam 2ip91 -- 24 January 2017
  * @author
  *    @id
  */

/* Don't make your lines longer than this one *********************************/

class UpsideDown {
    // 2.1
    String reverse(String s) {
        if (s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
    }
    
    // 2.2
    boolean isPalindrome(String s) {
        if (s.equals(reverse(s))) {
            return true;
        } else {
        return false;
        }
    }
    
    // 2.3
    void upsideDown(String[] text) {
        
        if (text.length == 0) {
            return;
        }
        
        System.out.println(reverse(text[text.length - 1]));
        String[] temp = new String[text.length - 1];
        System.arraycopy(text, 0, temp, 0, text.length - 1);
        upsideDown(temp);
    }
}
