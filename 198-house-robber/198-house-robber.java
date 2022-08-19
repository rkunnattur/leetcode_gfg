class Solution {
    
    public int rob(int[] nums) {
        int len = nums.length;
        int[] houseRobber = new int[len];
         
       /* if(len == 1) return nums[0];
        
        int maxOf2 = Math.max(nums[0], nums[1]);
        if(len == 2) return maxOf2;
         
        houseRobber[0] = nums[0]; houseRobber[1] = maxOf2; */
        
        Arrays.fill(houseRobber, -1);
        
        return robR(nums, len, 0, houseRobber);
     }
    
    public int robR(int[] nums, int len, int idx, int[] houseRobber) {
        if(idx >= len) return 0;
        
        if(houseRobber[idx] != -1) return houseRobber[idx];
        
        houseRobber[idx] = Math.max(nums[idx] + robR(nums, len, idx+2, houseRobber), robR(nums, len, idx+1, houseRobber)); 
        
        return houseRobber[idx];
    }
    
    public int robI(int[] nums, int len) {
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