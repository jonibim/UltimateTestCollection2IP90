import java.util.ArrayList;
class Conference {

    ArrayList<Joke> conference = new ArrayList<>();

    void add(Joke j) {
        conference.add(j);
    }

    int totalDuration() {
        return 0;
    }

    // tester / demo method
    public static void main(String[] args) {
        Conference conference = new Conference();
    }
}
class Joke{

}