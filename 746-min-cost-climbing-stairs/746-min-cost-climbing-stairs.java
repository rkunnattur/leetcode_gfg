class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] mincost = new int[n];
        Arrays.fill(mincost, -1);
        
        return Math.min(minCostClimbingStairsR(cost, mincost, n-1), minCostClimbingStairsR(cost, mincost, n-2));
    }
    
    public int minCostClimbingStairsR(int[] cost, int[] mincost, int n) {
        
        if(n < 0) return 0;
            
        if(n <= 1) return cost[n];
        
        if (mincost[n] != -1) return mincost[n];
        
        mincost[n] = cost[n]
            + Math.min(minCostClimbingStairsR(cost, mincost, n-1), minCostClimbingStairsR(cost, mincost, n-2));
        
        return mincost[n];
    }
}