class Solution {
    
    // Optimized DP approach TC: O(NLogN)
    public int findLongestChain(int[][] pairs) {
        //Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(pairs, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int longestChain = 0, curr = Integer.MIN_VALUE;

        for (int[] p: pairs) {
            if(curr < p[0]) {
                curr = p[1];
                longestChain += 1;
            }
        }
        
        return longestChain;
    }
    
    // TC: O(N^2)
    public int findLongestChain2(int[][] pairs) {
        int len = pairs.length, longestChain = 0;
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int[] longestChainDp = new int[len];
        Arrays.fill(longestChainDp, 1);
        
        if(len <= 1) return 1;
        
        for(int second = 1; second < len; second++) {
            for(int first = 0; first < second; first++) {
                if(pairs[first][1] < pairs[second][0]) {
                    longestChainDp[second] = Math.max(longestChainDp[second], longestChainDp[first] + 1); 
                }
            }
            
            longestChain = Math.max(longestChain, longestChainDp[second]);
        }
        
        return longestChain;
    }
}