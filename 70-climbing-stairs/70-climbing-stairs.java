class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        
        //return climbStairsR(n, 0, ways);   
        return climbStairsI(n, ways);
    }
    
    public int climbStairsR(int n, int i, int[] ways) {
        if(i > n) return 0;
        
        if(i == n) return 1;
        
        if(ways[i] > 0) return ways[i];
        
        ways[i] = climbStairsR(n, i+1, ways) + climbStairsR(n, i+2, ways);
        
        return ways[i];
    }
    
    public int climbStairsI(int n, int[] ways) {
        if(n==1) return 1;
        ways[0] = 1; ways[1] = 1; ways[2] = 2;
        
        for(int i = 3; i <= n; i++) ways[i] = ways[i-1] + ways[i-2];
        
        return ways[n];
    }
}