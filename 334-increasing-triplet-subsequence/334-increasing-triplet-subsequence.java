class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int one = nums[0], two = Integer.MAX_VALUE;
        
        for(int num: nums) {
            if(num <= one) one = num;
            else if(num <= two) two = num;
            else return true;
        }
        
        return false;
    }
}