/**
 * author: Maxim Snoep
 * student-number: 1313517
 * date: --/--/20--
 * course: --
 * assignment: --
 */

//imports
import java.util.*;

//class initialization
class Joke {
    public String name;
    public String text;
    public int time;
    public double funFactor;
    
    void Joke(String n, String txt, int t, double fun) {
        name = n;
        text = txt;
        time = t;
        funFactor = fun;
    }
    
    int getTime() {
        return time;
    }
    
    double calculateFunniness() {
        return (funFactor / time);
    }
    
}

class InsultingJoke extends Joke {
    public String insultingTo;
    
    void InsultingJoke(String n, String txt, int t, double fun, String i) {
        insultingTo = i;
    }
    
    double calculateFunniness() {
        return ((funFactor * 1.5) / time);
    }
    
}

class Conference {
    ArrayList<Joke> jokes = new ArrayList<Joke>();
    
    void add(Joke j) {
        jokes.add(j);
    }
    
    int totalDuration() {
        int total = 0;
        for (int i = 0; i < jokes.size(); i++) {
            Joke joke = jokes.get(i);
            total += joke.getTime();
        }
        return total;
    }
    
}

class Demo {
    void run() {
        Conference conference = new Conference();
        Joke j = new Joke("Afgeleide",
                          "Twee functies komen elkaar tegen in de Kalverstraat...",
                          30, 5.0);
        conference.add(j);
        Joke k = new InsultingJoke("Pastoorke",
                                   "Guus en Theo komen elkaar tegen op het Stratums Eind...",
                                   120, 10.0, "Brabanders");
        conference.add(k);   
    }
    
    public static void main(String[] a) {
        (new Demo()).run();
    }
    
}






