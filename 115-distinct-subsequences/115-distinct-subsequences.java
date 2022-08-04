class Solution {
    Integer[][] uniqueWays;
    public int numDistinct(String s, String t) {
        uniqueWays = new Integer[s.length()+1][t.length()+1];
        return numDistinctI(s, t);
        //return computeUniqueWays(s, t, s.length(), t.length());
    }
    
    public int computeUniqueWays(String s, String p, int a, int b) {
        if(b == 0) return 1;
        if(a < b) return 0;
        
        if(uniqueWays[a][b] != null) return uniqueWays[a][b];
        
        int ways = 0;
        
        if(s.charAt(a-1) == p.charAt(b-1)) {
           ways = (uniqueWays[a-1][b-1] != null) ?  uniqueWays[a-1][b-1] : computeUniqueWays(s, p, a-1, b-1);
        }
        
        ways += (uniqueWays[a-1][b] != null) ? uniqueWays[a-1][b] :  computeUniqueWays(s, p, a-1, b);
        
        uniqueWays[a][b] = ways;
        
        return ways;
    }
    
    public int numDistinctI(String S, String T) {
	int sl = S.length();
	int tl = T.length();
	
    if(sl < tl) return 0;
        
	int [][] dp = new int[tl+1][sl+1];
        
	Arrays.fill(dp[0], 1);
	
	for(int t=1; t<=tl; ++t){		
		for(int s=1; s<=sl; ++s){
			if(T.charAt(t-1) == S.charAt(s-1)){
				dp[t][s] = dp[t-1][s-1];
			}
            
			dp[t][s] += dp[t][s-1];
		}	
	}
	
	return dp[tl][sl];
}
}