class Solution {
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> subseqList = new HashSet<>();
        generateSubSequences(nums, 0, new ArrayList<>(), subseqList);
        
        return new ArrayList(subseqList);
    }
    
    public void generateSubSequences(int[] nums, int curr, List<Integer> subseq, Set<List<Integer>> subseqList) {
        
        if(subseq.size() >= 2) subseqList.add(new ArrayList(subseq));
        
        for(int idx = curr; idx < nums.length; idx++) {
            if(subseq.size() == 0 || subseq.get(subseq.size() - 1) <= nums[idx]) {
                subseq.add(nums[idx]);
                generateSubSequences(nums, idx+1, subseq, subseqList);
                subseq.remove(subseq.size()-1);
            }
        }
    }
}