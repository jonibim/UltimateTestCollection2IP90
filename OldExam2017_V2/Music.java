import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class Music {
    ArrayList<Piece> pieces = new ArrayList<>();

    void printAll() {
        for (int i = 0; i < pieces.size(); i++) {
            System.out.print(pieces.get(i).toString());
        }
    }

    void demo() {
        demo1();
        System.out.println("-------------------");
        demo2();
    }

    void demo1() {
        Piece piece = new Piece("The Fifth", "London Symphony Orchestra");
        System.out.println(piece);

    }

    void demo2() {
        pieces.add(new Piece("The Fifth", "London Symphony Orchestra"));
        pieces.add(new Song("One More Cup Of Java", "Bob Dylan", 227));
        pieces.add(new Song("Are You With Me", "Lost Frequencies", 304));
        printAll();
    }

    public static void main(String[] a) {
        (new Music()).demo();
    }

    class Song extends Piece {
        int duration;
        int minutes;
        int seconds;

        Song(String title, String artist, int duration) {
            super(title, artist);
            this.duration = duration;
            convertTime();

        }

        void convertTime() {
            minutes = duration / 60;
            if (duration % 60 > 60) {
                minutes++;
                seconds = (duration % 60) % 60;
            } else {
                seconds = duration % 60;
            }
        }

        @Override
        public String toString() {
            return super.toString() + String.format("duration %d:%02d", minutes, seconds);
        }
    }

    class Piece {
        String title;
        String artists;

        Piece() {
            title = "Zonder title";
            artists = "NN";
        }

        Piece(String title, String artists) {
            this.title = title;
            this.artists = artists;
        }

        @Override
        public String toString() {
            return title + " -- " + artists + "\n";
        }
    }
}
