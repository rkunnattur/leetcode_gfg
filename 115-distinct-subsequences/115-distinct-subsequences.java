class Solution {
    Integer[][] uniqueWays;
    public int numDistinct(String s, String t) {
        uniqueWays = new Integer[s.length()+1][t.length()+1];
        
        return computeUniqueWays(s, t, s.length(), t.length());
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
}