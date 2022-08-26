class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int len = nums.length, longestSeq = 1, maxIdx = -1;
        
        int[] lis = new int[len], noOfLis = new int[len];
        Arrays.fill(lis, 1);
        Arrays.fill(noOfLis, 1);
        
        for(int curr = 0; curr < len; curr++) {
            for(int prev = 0; prev < curr; prev++) {
                if(nums[prev] < nums[curr] && lis[prev] + 1 > lis[curr]) {
                    lis[curr] = lis[prev] + 1;
                    // inherit prev count
                    noOfLis[curr] = noOfLis[prev];
                    
                }else if(nums[prev] < nums[curr] && lis[prev] + 1 == lis[curr]) {
                     // add to curr count from prev count
                       noOfLis[curr] += noOfLis[prev];
                }
            }
            
            longestSeq = Math.max(longestSeq, lis[curr]);
        } 
        
        int noOfMaxLis = 0;
        for(int i = 0; i < len; i++) 
            if(lis[i] == longestSeq)  noOfMaxLis += noOfLis[i];
        
        return noOfMaxLis;  
    }
                   
    
}