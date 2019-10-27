class Difference {
    
    boolean allZero(int[] nums) {
        int zeroAmount = 0;
        if(nums == null) {
            return true;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroAmount++;
            }
        }
        if (zeroAmount == nums.length) {
            return true;
        } else {
            return false;
        }
    }
    
    int[] difference(int[] nums) {
        int[] diff = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i+1] - nums[i];
        }
        return diff;
    }
    
    boolean isConstant(int[] nums) {
        if (nums.length <= 1 || nums == null) {
            return true;
        }
        return allZero(difference(nums));
    }
    
    boolean isLinear(int[] nums) {
        return isConstant(difference(nums));
    }
    
    //y = a*x + b
    void printFunction(int[] nums) {
        int a;
        int b = nums[0];
        int dif[] = difference(nums);
        a = dif[0];
        System.out.println(a + "x + " + b);
    }
    
    int degree(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (isLinear(nums)) {
            return 1;
        } else {
            return 1 + degree(difference(nums));
        }
    }
    
    public static void main(String[] args) {
        Difference dif = new Difference();
        int[] a = {1,4,7,10};
        System.out.println(dif.degree(a));
        dif.printFunction(a);
    }  
}