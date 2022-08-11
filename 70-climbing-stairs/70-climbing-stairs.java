class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        
        return climbStairsR(n, 0, ways);   
    }
    
    public int climbStairsR(int n, int i, int[] ways) {
        if(i > n) return 0;
        
        if(i == n) return 1;
        
        if(ways[i] > 0) return ways[i];
        
        ways[i] = climbStairsR(n, i+1, ways) + climbStairsR(n, i+2, ways);
        
        return ways[i];
    }
}