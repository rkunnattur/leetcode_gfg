class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return computeLISI(nums);
    }
    
    public int computeLISI(int[] nums) {
        int len = nums.length, max = -1;
        int[] lis = new int[len];
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) lis[i] = Math.max(lis[i], lis[j]);
            }
            
            lis[i]++;
            max = Math.max(max, lis[i]);
        }
        System.out.printf("lis: %s\t", Arrays.toString(lis));
        return max;
    }
}