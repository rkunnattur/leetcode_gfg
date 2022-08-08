class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if(len <= 1) return len;
        
        Arrays.sort(envelopes, (o1, o2) -> {
            return (o1[0] != o2[0]) ? o1[0] - o2[0] : o2[1] - o1[1];
        });
        
        int[] height = new int[len];
        int idx = 0;
        for(int[] envelope: envelopes) height[idx++] = envelope[1];
    
        return lis(height);
    }
    
    public int lis(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len];
        
        int end = 0;
        for(int n: nums) {
            int i = Arrays.binarySearch(lis, 0, end, n);
            if(i < 0) i = -(i+1);
            
            lis[i] = n;
            if(i == end) end++;
        }
        
        return end;
    }
}