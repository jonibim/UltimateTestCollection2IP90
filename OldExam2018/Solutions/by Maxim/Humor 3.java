import java.util.*;

class Humor {
    public static void main(String[] args) {
        Conference conference = new Conference();
        Joke j = new Joke("Afgeleide","Twee functies komen elkaar tegen in de Kalverstraat...",30, 5.0);
        conference.add(j);
        Joke k = new InsultingJoke("Pastoorke","Guus en Theo komen elkaar tegen op het Stratums Eind...",120, 10.0,"Brabanders");
        conference.add(k);
    }    
}

class Joke {
    String jokeName;
    String jokeText;
    int jokeTime;
    double funFactor;
    
    Joke() {
        jokeName = "No Jokes";
        jokeText = "knock knock?";
        jokeTime = 0;
        funFactor = 0.0;
    }
    
    Joke(String jokeName, String jokeText, int jokeTime, double funFactor) {
        this.jokeName = jokeName;
        this.jokeText = jokeText;
        this.jokeTime = jokeTime;
        this.funFactor = funFactor;
    }
}

class Conference {
    ArrayList<Joke> jokes = new ArrayList<Joke>();
    
    void add(Joke j) {
        jokes.add(j);
    }
    
    int getTime(Joke joke) {
        return joke.jokeTime;
    }
    
    int totalDuration() {
        int i = 0;
        int totalTime = 0;
        for ( Joke j : jokes ) { 
            totalTime += getTime(jokes.get(i));
            i++;
        } 
        return totalTime;
    }
}

class InsultingJoke extends Joke {
    String socialGroup;
    
    InsultingJoke(String jokeName, String jokeText, int jokeTime, double funFactor, String socialGroup) {
        super(jokeName, jokeText, jokeTime, funFactor);
        this.socialGroup = socialGroup;
    }
    
}