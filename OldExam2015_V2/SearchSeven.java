public class SearchSeven {
    boolean has7(int[] a, int lo, int hi) {
        if (a.length == 0) {
            return false;
        }
        if (lo == hi) {
            return false;
        }
        if (a[hi - 1] < 7) {
            return false;
        }
        if (a[lo] > 7) {
            return false;
        }
        if (a[lo] == 7) {
            return true;
        }
        return has7(a, lo + 1, hi);
    }

    void run() {
        int[] a = {1, 2, 4, 5, 5, 7, 7};
        System.out.println(has7(a, 0, 6));
    }

    public static void main(String[] args) {
        new SearchSeven().run();
    }

}
