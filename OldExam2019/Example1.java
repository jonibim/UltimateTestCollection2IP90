

public class Example1 {
    class Valentine{
        String title;
        String[] cards;
        void printRoses(int n){
            int x;
            for (int i=0; i < cards.length; i++){
                String c = cards[i];
                x = c.length();
                if (c.length() >= n) {
                    System.out.print(c + " ");
                }
                System.out.print(i);
                }
            }
        }
    }