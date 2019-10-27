/** 
 * Humor -- solution to exercise 4 of Exam 2ip90 of 20 January 2015
 */

/*
 * 4.2
 */ 
import java.util.ArrayList;

class Humor {
    ArrayList<Joke> jokes;
    
    Humor() {
        jokes = new ArrayList<Joke>();
    }
    
    void add( Joke j ) {
        jokes.add( j );
    }   
    
    /*
     * 4.3a
     */
//    void overview() {
//        int total = 0;
//        for ( Joke j : jokes ) {
//            total += j.getSpace();
//        }
//        System.out.println( "Total joking space required: "+total+" mm" );
//    }  
    
    /* 4.3a and 4.5c
     * 
     */
    void overview() {
        int total = 0;
        double funniness = 0;
        for ( Joke j : jokes ) {
            total += j.getSpace();
            funniness += j.calculateFunniness();
        }
        double averageFunniness = funniness / jokes.size();
        System.out.println( "Total joking space required: "+total+" mm" );
        System.out.println( "Average funniness: "+averageFunniness );
    }      
    
    // testing
    void test() {
        Joke j1 = new Joke( "Scouting Magazine 1979", 
            "What's the difference between mashed potatoes and pea green soup?\n"+
            "--\nAnyone can mash potatoes",              
        30, 8.0 );
        add( j1 );
        j1.print();
        
        Joke j2 = new InsultingJoke( "Street workers", 
            "Klaas sees two men working in the street. One digs a hole, the other fills it up again.\n"+
            "Then they move five metres and repeat the procedure.\n"+
            "Klaas gets very curious and asks what they are doing. \n"+
            "One answers: 'Usually we are with three. But Sjef is ill today and Sjef holds the tree.'",             
        65, 7.0, "Limburgians" );
        add( j2 );
        j2.print();
        overview();
    }
    
    public static void main( String[] a ) {
        ( new Humor() ).test();
    }
}
    
/*
 * 4.1
 */

class Joke {
    String name;
    String text;
    int space; //mm
    double funFactor; //between 0.0 and 10.0
    
    Joke( String name, String description, int space, double funFactor ) {
        this.name = name;
        this.text = description;
        this.space = space;
        this.funFactor = funFactor;
    }
    
    /*
     * 4.3b
     */
    int getSpace() {
        return space;
    }
    
    void print() {
        System.out.println("***************************");
        System.out.println( name );
        System.out.println("---------------------------");
        System.out.println( "space: "+space+"    fun factor: "+funFactor );
        System.out.println("***************************");
        System.out.println( text );
        System.out.println("***************************");
    }
    
    // 4.5a
    double calculateFunniness() {
        return funFactor / space;
    }
}

/**
 * 4.4
 */

class InsultingJoke extends Joke {
    String target; // social group likely to be insulted by this joke
    
    InsultingJoke( String name, String description, int space, double funFactor, String group ) {
        super( name, description, space, funFactor );
        this.target = group;
    }
    
    @Override 
    void print() {
        super.print();
        System.out.println( "Target group: "+target );
        System.out.println("***************************");
    }
    
    // 4.5b
    double calculateFunniness() {
        double multiplier;
        if ( target.equals( "Limburgians" ) ) {
            multiplier = 2.0;
        } else {
            multiplier = 1.5;
        }
        return multiplier * funFactor / space;
        // alternative:
        // return multiplier * super.calculateFunniness();
    }
}
       
