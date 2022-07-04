class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nos = new HashMap<>();
       for (int i=0;i<nums.length;i++){
           int complement = target-nums[i];
           if(nos.containsKey(complement)){
               return new int[] {nos.get(complement),i};
           }
           nos.put(nums[i],i);
       }
        return new int[] {-1,-1};
    }   
}