class Solution {
    int[][] uniqueWays;
    public int numDistinct(String s, String t) {
        uniqueWays = new int[s.length()+1][t.length()+1];
        //Integer[][] dp=new Integer[s.length()+1][t.length()+1];
        for(int[] ways: uniqueWays)  Arrays.fill(ways, -1);
        return computeUniqueWays(s, t, s.length(), t.length());
        //return f(s, t, s.length(), t.length(), dp);
    }
    
    public int f(String s, String t,int i,int j,Integer[][] dp){
        //base case
        if(i>=0 && j==0)return 1;
        if(i==0 && j>0)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        //consider s[i] in subsequence + don't consider s[i]
        int ans=0;
        if(s.charAt(i-1)==t.charAt(j-1)){
            ans=dp[i-1][j-1]!=null?dp[i-1][j-1]: f(s,t,i-1,j-1,dp);
        }
            
        ans += dp[i-1][j]!=null?dp[i-1][j]: f(s,t,i-1,j,dp);
        
        dp[i][j]=ans;
        return ans;
        
    }
    
    public int computeUniqueWays(String s, String p, int a, int b) {
        if(a >= 0 && b == 0) return 1;
        if(a == 0 && b > 0) return 0;
        
        if(uniqueWays[a][b] != -1) return uniqueWays[a][b];
        
        int ways = 0;
        
        if(s.charAt(a-1) == p.charAt(b-1)) {
           ways = (uniqueWays[a-1][b-1] != -1) ?  uniqueWays[a-1][b-1] : computeUniqueWays(s, p, a-1, b-1);
        }
        
        ways += (uniqueWays[a-1][b] != -1) ? uniqueWays[a-1][b] :  computeUniqueWays(s, p, a-1, b);
        
        uniqueWays[a][b] = ways;
        
        return ways;
    }
}