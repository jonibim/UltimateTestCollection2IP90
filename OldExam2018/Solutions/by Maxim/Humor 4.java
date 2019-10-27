import java.util.*;


class Conference {
    
    ArrayList<Joke> conference = new ArrayList<>();
    
    void add(Joke j) {
        conference.add(j);
    }
    
    int totalDuration() {
        int sum = 0;
        
        for (int i = 0; i < conference.size(); i++) {
            sum = sum + conference.get(i).duration;
        }
        
        return sum;
    }
       
    // tester / demo method
    public static void main(String[] args) {
        Conference conference = new Conference();
        Joke j = new Joke("Afgeleide",
                          "Twee functies komen elkaar tegen in de Kalverstraat...",
                          30, 5.0);
        conference.add(j);
        Joke k = new InsultingJoke("Pastoorke",
                                   "Guus en Theo komen elkaar tegen op het Stratums Eind...",
                                   120, 10.0, "Brabanders");
        conference.add(k);
        
        System.out.println(conference.totalDuration());
        System.out.println(k.calculateFunniness());
    }
}


class Joke {
    
    String name;
    String text;
    int duration; // in seconds
    double funFactor; // value between 0.0 and 10.0
    
    Joke() {
        name = "NN";
        text = "tt";
        duration = 0;
        funFactor = 0;
    }
    
    Joke(String name, String text, int duration, double funFactor) {
        this.name = name;
        this.text = text;
        this.duration = duration;
        this.funFactor = funFactor;
    }
    
    double calculateFunniness() {
        double funniness = (funFactor / duration);
        
        return funniness;
    }
}


class InsultingJoke extends Joke{
    
    String insultTarget;
    
    InsultingJoke(String name, String text, int duration, double funFactor, String insultTarget) {
        super(text, name, duration, funFactor);
        this.insultTarget = insultTarget;
    }
    
    @Override
    double calculateFunniness() {
        double funniness = ((funFactor * 1.5) / duration);
        
        return funniness;
    }
}