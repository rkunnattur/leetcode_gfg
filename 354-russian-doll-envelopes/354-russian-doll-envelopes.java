class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n <= 1) return n;
        Arrays.sort(envelopes, (o1, o2)->{
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        
        int[] heights = new int[n];
        int idx = 0;
        for(int[] envelope : envelopes){
            heights[idx++] = envelope[1];
        }
        return lengthOfLIS(heights);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){
                i = - (i+1);
            }
            dp[i] = num;
            if(i==len) len += 1;
        }        
        return len;        
    }   
}