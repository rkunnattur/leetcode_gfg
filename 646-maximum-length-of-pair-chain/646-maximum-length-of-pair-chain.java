class Solution {
    
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        int ans = 0;
        for (int x: dp) if (x > ans) ans = x;
        return ans;
    }
    
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length, longestChain = 0, currLongestChain = 1;
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int[] longestChainDp = new int[len];
        Arrays.fill(longestChainDp, 1);
        
        if(len <= 1) return 1;
        
        for(int second = 1; second < len; second++) {
            currLongestChain = 1;
            for(int first = 0; first < second; first++) {
                if(pairs[first][1] < pairs[second][0]) {
                    currLongestChain = longestChainDp[second] = Math.max(longestChainDp[second], longestChainDp[first] + 1); 
                }
            }
            
            longestChain = Math.max(longestChain, currLongestChain);
            System.out.printf("currLongestChain: %d; longestChain: %d;\t", currLongestChain, longestChain);
        }
        
       /* for(int n: longestChainDp) {
            longestChain = Math.max(longestChain, n);
        } */
        System.out.printf("\n\noutside loop >> longestChainDp: %s; longestChain: %d;\t", Arrays.toString(longestChainDp), longestChain);
        return longestChain;
    }
}