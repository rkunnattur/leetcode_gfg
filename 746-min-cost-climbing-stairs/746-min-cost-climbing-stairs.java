class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] mincost = new int[n+1];
        //Arrays.fill(mincost, -1);
        
        return minCostClimbingStairsR(cost, mincost, n);
    }
    
    public int minCostClimbingStairsR(int[] cost, int[] mincost, int n) {
        
       // if(n < 0) return 0;
            
        if(n <= 1) return 0;
        
        if (mincost[n] != 0) return mincost[n];
        
        mincost[n] = Math.min(cost[n-1] + minCostClimbingStairsR(cost, mincost, n-1), cost[n-2] + minCostClimbingStairsR(cost, mincost, n-2));
        
        return mincost[n];
    }
}