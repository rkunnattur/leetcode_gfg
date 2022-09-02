class Solution {
    public int singleNumber(int[] nums) {
        int uniqueInt = 0;
        for(int n: nums) {
            uniqueInt ^= n;
        }
        
        return uniqueInt;
    }
}