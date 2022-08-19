class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(len == 1) return nums[0];
        int maxOf2 = Math.max(nums[0], nums[1]);
        if(len == 2) return maxOf2;
        
        int[] houseRobber = new int[len];
        
        houseRobber[0] = nums[0]; houseRobber[1] = maxOf2;
        
        for(int i = 2; i < len; i++) {
            houseRobber[i] = Math.max(nums[i] + houseRobber[i-2], houseRobber[i-1]);   
        }
        
        return houseRobber[len-1];
    }
}