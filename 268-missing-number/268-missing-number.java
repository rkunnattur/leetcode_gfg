class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, missingNumber = n;
        
        for(int i = 0; i < n; i++) {
            missingNumber ^= i ^ nums[i];
        }
        
        return missingNumber;
    }
}