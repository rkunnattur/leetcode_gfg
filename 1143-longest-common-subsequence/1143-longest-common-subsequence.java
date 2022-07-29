
/*
LCS(i, j) = maximum (LCS(i-1, j-1] + 1,       //if(A[i] = B[j])
                
                     LCS(A[i-1], B[j],      else 
                     LCS(A[i], B[j-1] ) */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return lcsI(text1, text2);
    }
    
    public int longestCommonSubsequenceR(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] lcs = new int[n][m];
        return lcsR(s1, s2, n-1, m-1, lcs);
    }
    
    public int lcsR(String s1, String s2, int i, int j, int[][] lcs) {
        if(i == -1 || j == -1) return 0;
        
        if(lcs[i][j] != 0) return lcs[i][j];
        
        if(s1.charAt(i) == s2.charAt(j))
            lcs[i][j] = 1 + lcsR(s1, s2, i-1, j-1, lcs);
        else 
            lcs[i][j] =  Math.max(lcsR(s1, s2, i, j-1, lcs), lcsR(s1, s2, i-1, j, lcs));
        
        return lcs[i][j];
    }
    
    
     public int lcsI(String s1, String s2) {
         int n = s1.length(), m = s2.length();
         
         int[][] dp = new int[n + 1][m + 1];
         
         for(int i = 1; i <= n; i++) {
             for(int j = 1; j <= m; j++) {
                 if(s1.charAt(i-1) == s2.charAt(j-1)) {
                     dp[i][j] = 1 + dp[i-1][j-1];
                 } else {
                     dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                 }
             }
         }
         
         return dp[n][m];
     }
    
}