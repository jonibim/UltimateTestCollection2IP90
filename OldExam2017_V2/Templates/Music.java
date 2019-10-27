import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class Music {

        void demo() {
            demo1();
            System.out.println("-------------------");
            demo2();
        }

        void demo1() {
            Piece piece = new Piece();
            System.out.println( piece );

        }

        void demo2() {
        }

        public static void main(String[] a) {
            (new Music()).demo();
        }

    }
}
