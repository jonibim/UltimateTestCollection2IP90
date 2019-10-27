import org.jetbrains.annotations.NotNull;

public class Differentiation {
    boolean allzero(int[] nums){
        if (nums.length>0) {
            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount += 1;
                }
            }
            if (zeroCount == nums.length) {
                return true;
            }
            return false;
        }

        return true;
    }

    int[] difference (int[] nums){
        int[] temp = new int[nums.length-1];
        for (int i=0; i<temp.length;i++){
            temp[i] = nums[i+1] - nums[i];
        }
        return temp;
    }
    boolean isConstant (int[] nums) {
        if (!allzero(nums)) {
            for (int i=0; i<nums.length-1; i++){
                if (nums[i+1] - nums[i] != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    String printArray(int[] nums){
        String temp = "";
        for (int i=0; i<nums.length; i++){
            temp += Integer.toString(nums[i]);
            if (i<nums.length-1){
                temp+=", ";
            }
        }
        return "{ "+temp+" }";
    }

    String getType(int[] nums){
        if(isConstant(nums)){
            return printArray(nums)+ " is constatnt";
        }
        if(isConstant(difference(nums))){
            return printArray(nums)+ " is linear";
        }
        if(isConstant((difference(difference(nums))))){
            return printArray((nums))+ " is quadratic";
        }
        return printArray(nums)+ "is other";
    }
    int degree(int[] nums){
        int count=0;
        if (allzero(nums)){
            return 0;
        }
        if (!isConstant(nums)){
            count+=1;
        }
        return (degree(difference(nums)))+count;
    }


    void test(){
        int[] nums = {2,4,5,6};
        int[] diff = {1, 4, 9, 16 };
        System.out.println(printArray(nums));
        System.out.println(degree(diff));


    }

    public static void main(String[] args) {
        Differentiation d = new Differentiation();
        d.test();
    }
}
