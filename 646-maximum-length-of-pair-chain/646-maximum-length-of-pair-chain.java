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