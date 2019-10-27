import java.util.ArrayList;

public class Skating {

    static class Skater{
        double[] times;

        Skater(double[] timelapse){
            times = timelapse;
        }

        double[] getLapTime(){
            double[] temp = new double[times.length-1];
            for (int i=0; i<times.length-1; i++){
                temp[i] = times[i+1] - times[i];
            }
            return temp;
        }

        void statLapTime(){
            double[] timelapse = getLapTime();
            double min = Integer.MAX_VALUE;
            double max = 0;
            int i_max=0;
            int i_min=0;
            for (int i=0; i < timelapse.length; i++){
                if (max <= timelapse[i]){
                    max = timelapse[i];
                    i_max=i;
                }

                if (min > timelapse[i]){
                    min = timelapse[i];
                    i_min=i;
                }
            }
            System.out.printf("first fastest: lap number %d of  %.2f seconds\n", i_min+1,min);
            System.out.printf("last slowest: lap number %d of %.2f seconds\n", i_max+1,max);
        }

        double[] diffFlats(){
            double[] temp= new double[getLapTime().length];
            for (int i=0;i< temp.length;i++){
                temp[i]=Math.abs(getLapTime()[i]);
            }
            return temp;

        }
        int calcFlats() {
            double[] temp = diffFlats();
            int count_max=0;
            int count=0;
            for (int i=0; i<temp.length; i++){
                if (temp[i] > 0.5){
                    count=0;
                }
                if (temp[i] < 0.5){
                    count+=1;
                }
                if(count_max < count){
                    count_max = count;
                }
            }
            return count_max;

        }

    }

    public static void main(String[] args) {
        double[] time = {30.12,30.555,30.8,30.8,30.7,30.6,31.0,31.6,31.7,31.8};
        Skater s = new Skater(time);
        System.out.println(s.getLapTime());
        s.statLapTime();
        System.out.println(s.calcFlats());
    }

}
