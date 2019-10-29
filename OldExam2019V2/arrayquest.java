import java.util.Arrays;

// Question 2 -- Array Fun

class ArrayQuest {
    int[] clamp(int[] a, int max) {
        //return null if array is empty
        if (a.length == 0) {
            return null;
        }

        //replace every number in array which is bigger than max
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                a[i] = max;
            }
        }
        return a;
    }

    int maxpos(String s) {
        /*
        First I set up a max char with the lowest value
        I do this because we will than compare this variables
        with the other variables in the String (which is an array
        composed of char elements), and if it is bigger than the
        this minimum variable it will be assigned to this max variable,
        and therefore, the max becomes the new "minimum" when it is compared
        to the other elements. If no element is bigger than this "minimum"
        than it is safe to say that this is our biggest element;
         */
        char max = '0';
        /*
        As a char max, i took the char 0 as it is the
        "lowest" char element in the char table, because all
        number-elements in ASCII table are lower than letter-elements.

        Another approach for this would be also setting
        the minimum as the first char in the array, but than
        we would need to add an check if the array is empty first
        thus by following my approach as described above
        and demonstrated below we avoid this step
         */
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= max) {
                max = s.charAt(i);
                index = i;
            }
        }
        return index; //change this
    }

    String sort(String s) {
        //Base Case
        if (s.length() == 0) {
            return "";
        }
        //A case which is always true
        //and prevents the recursion from failing
        //or throwing exceptions
        if (s.length() == 1) {
            return s;
        }
        //Remove the biggest latter, by spiting at the index where the biggest element is
        //and adding the new two created strings
        String newStr = s.substring(0, maxpos(s)) + s.substring(maxpos(s) + 1);
        return sort(newStr) + s.charAt(maxpos(s));
    }

    void demo() {
        //2.1
        int[] a = {1, 5, 2, 3, 6, 7};
        int m = 5;
        System.out.println(Arrays.toString(a) + " " + m);
        System.out.println(Arrays.toString(clamp(a, m)));

        //2.2
        String s = "lal";
        System.out.println(s + "-> " + maxpos("lal"));

        //2.3
        String t = "yebab";
        System.out.println(t + "-> " + sort(t));
    }

    static public void main(String[] a) {
        (new ArrayQuest()).demo();
    }
}