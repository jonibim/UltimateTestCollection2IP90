import java.util.ArrayList;

class Conference {

    ArrayList<Joke> conference = new ArrayList<>();

    void add(Joke j) {
        conference.add(j);
    }

    int totalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < conference.size(); i++) {
            totalDuration += conference.get(i).duration;
        }
        return totalDuration;
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
                120,
                10.0,
                "Brabanders");
        conference.add(k);
        conference.conference.get(0).print();
        conference.conference.get(1).print();
    }
}

class Joke {

    String nameOfJoke;
    String descOfJoke;
    int duration;
    double funFactor;

    double calculateFunnies() {
        return funFactor / duration;
    }

    /* In case you need to conver the time in minutes and seconds
    int minutes = 0;
    int seconds = 0;
    void convertTime() {
        minutes = duration / 60;
        if (duration % 60 > 60) {
            minutes++;
            seconds = (duration % 60) % 60;
        } else {
            seconds = duration % 60;
        }
    }*/

    Joke() {
        nameOfJoke = "NA";
        descOfJoke = "NA";
        duration = 0;
        funFactor = 0;
    }

    public Joke(String nameOfJoke, String descOfJoke, int duration, double funFactor) {
        this.nameOfJoke = nameOfJoke;
        this.descOfJoke = descOfJoke;
        this.duration = duration;
        this.funFactor = funFactor;
    }

    void print() {
        System.out.println(
                "Name of Joke: " + nameOfJoke + "\n"
                        + "Description of Joke: " + descOfJoke + "\n"
                        + "Duration of Joke: " + duration + "\n"
                        + "Fun Factor: " + funFactor + "\n"
                        + "Funiness: " + calculateFunnies() + "\n"
        );
    }
}

class InsultingJoke extends Joke {
    String targetGroup;

    public InsultingJoke(String nameOfJoke, String descOfJoke, int duration, double funFactor, String targetGroup) {
        super(nameOfJoke, descOfJoke, duration, funFactor);
        this.targetGroup = targetGroup;
    }

    @Override
    double calculateFunnies() {
        return (funFactor * 1.5) / duration;
    }
}