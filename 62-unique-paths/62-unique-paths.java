class Solution {
    public int uniquePaths(int m, int n) {
        
        return uniquePathsIOpt2(m, n);
    }
    
    public int uniquePathsI(int n, int m) {
        
        int[][] dp = new int[n+1][m+1];

        for (int r = 0; r < n; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < m; c++) {
            dp[0][c] = 1;
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c - 1];
            }
        }

        return dp[n-1][m - 1];
        
    }
    
    public int uniquePathsIOpt1(int n, int m) {
        
        int[][] dp = new int[2][m];

        for (int r = 0; r < 2 && r < n; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < m; c++) {
            dp[0][c] = 1;
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                dp[r%2][c] 
                    = dp[(r-1) %2][c];
                if(c >= 1)dp[r%2][c] += dp[r%2][c - 1];
            }
        }

        return dp[(n-1)%2][m - 1];
        
    }
    
    public int uniquePathsIOpt2(int n, int m) {
        
        int[] dp = new int[m];

        Arrays.fill(dp, 1);

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                dp[c] = dp[c-1] + dp[c];
            }
        }

        return dp[m-1];
        
    }
}