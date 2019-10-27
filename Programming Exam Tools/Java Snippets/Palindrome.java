public static boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (Character.isLetter(c)) {
            sb.append(c);
        }
    }
    String forward = sb.toString().toLowerCase();
    String backward = sb.reverse().toString().toLowerCase();
    return forward.equals(backward);
}