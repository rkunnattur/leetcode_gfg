class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        
        //return combinationSum4R(nums, target, new Integer[target+1]);
        return combinationSum4I(nums, target);
    }
    
    public int combinationSum4R(int[] nums, int target, Integer[] cs) {
        if(target == 0) return 1;
        
        if(target < 0) return 0;
        
        if(cs[target] != null) return cs[target];
        
        int count = 0;
        for(int num: nums) {
            count += combinationSum4R(nums, target-num, cs);
        }
        
        return cs[target] = count;
    }
    
    public int combinationSum4I(int[] nums, int target) {
        
        int[] cs = new int[target+1];
        cs[0] = 1;
        
        for(int t = 1; t <= target; t++) {
            for(int k: nums) {
                if(t-k >= 0) cs[t] += cs[t - k];
                else continue;
            }
        }
        
        return cs[target];
    }
    
}