public class Example2 {
    class ExceptionFragment {
        void fragment() {
            int x = 0;
            try {
                x += 1;
                m();
                x += 2;
            } catch (NullPointerException e) {
                x += 4;
            }
            System.out.println(x);
        }
    }

        void m(){ }

        public static void main(String[] args) {

        }
    }
