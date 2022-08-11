class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        
        return climbStairsR(n, ways);   
        //return climbStairsI(n, ways);
    }
    
    public int climbStairsR(int n, int[] ways) {
        if(n <= 2) return n;
        if(ways[n] != 0) return ways[n];
        
        ways[n] = climbStairsR(n-1, ways) + climbStairsR(n-2, ways); 
        
        return ways[n];
    }
    
    public int climbStairsI(int n, int[] ways) {
        if(n==1) return 1;
        ways[0] = 1; ways[1] = 1; ways[2] = 2;
        
        for(int i = 3; i <= n; i++) ways[i] = ways[i-1] + ways[i-2];
        
        return ways[n];
    }
}