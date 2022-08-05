class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        
        return combinationSum4R(nums, target, new Integer[target+1]);
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
}