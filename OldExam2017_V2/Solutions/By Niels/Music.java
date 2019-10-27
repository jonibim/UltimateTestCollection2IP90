import java.util.*;
import java.util.ArrayList;

class Music{
    ArrayList<Piece> pieces = new ArrayList<Piece>();
    
    void demo(){
        demo1();
        System.out.println("-------------------");
        demo2();
    }
    
    void demo1(){
        Piece piece;
        piece = new Piece("The Fith", "Londen Symphony Orchestra");
        System.out.println( piece );
    }
    
    
    void demo2(){
       pieces.add(new Piece("The Fith", "Londen Symphony Orchestra"));
       pieces.add(new Song("One More Cup Of Java", "Bob Dylan", 347));
       pieces.add(new Song("Natural", "Imagine Dragons", 315));
       printAll();
    }
    
    void printAll() {
        for ( Piece p : pieces ) { 
            System.out.println( "--------------------------------" ); 
            System.out.println(p); 
        }
    }
    
    public static void main(String[] a){
        (new Music()).demo();
    }
}

class Piece {
    String title;
    String artist;
    
    Piece() {
        title = "Zonder titel";
        artist = "NN";
    }
    
    Piece(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    @Override
    public String toString() {
        return title + " -- " + artist;
    }
  }

class Song extends Piece {
    int duration;
    
    Song(String title, String artist, int duration) {
        super(title, artist);
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nduration " + duration/100 + ":" + duration%100;
    }
}