public class Differefence2015 {
    boolean allZero(int[] nums){
        if (nums.length>0){
            for (int i=0; i<nums.length; i++){
                if (nums[i] != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    int[] difference(int[] nums){
        int[] temp = new int[nums.length-1];
        for  (int i=0; i<temp.length; i++){
            temp[i] = nums[i+1]-nums[i];
        }
        return temp;
    }

    boolean isConstant(int[] nums){
        if (allZero(difference(nums))){
            return true;
        }
        return false;
    }

    boolean isLinear(int[] nums){
        if(isConstant(difference(nums))){
            return true;
        }
        return false;
    }

    void printFunction(int[] nums){
        int slope = difference(nums)[0];
        int addition = nums[0];
        System.out.printf("%dx + %d\n",slope,addition);
    }

    int degree(int[] nums){
        int count=0;
        if(allZero(nums)){
            return 0;
        }

        if(!isConstant(difference(nums))){
            count+=1;
        }

        return degree(difference(nums))+count;
    }

    void run(){
        int[] diff = {1, 4, 9, 16 };
        int[] demo = {1, 4, 7, 10};
        printFunction(demo);
        System.out.println(degree(diff));
        System.out.println(isLinear(demo));
    }

    public static void main(String[] args) {
        Differefence2015 d = new Differefence2015();
        d.run();
    }
}
