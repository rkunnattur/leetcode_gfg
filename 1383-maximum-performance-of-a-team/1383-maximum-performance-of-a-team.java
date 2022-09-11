class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] team = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            team[i][0] = speed[i];
            team[i][1] = efficiency[i];
        }
        
        Arrays.sort(team, (o1, o2) -> {
          return o2[1] - o1[1]; 
            
            // sort based on efficency in descending order, as for each iteration, consider members with higher efficiency
        });
        
        long teamPerformance = 0, teamSpeed = 0, M = (long) (1L * (1e9) + 7L);
        
        // maintains a collection of members with highest speeds, for each speed compute performance of team max(speed1 + speed2 + speed3) * minEfficiiency)
        PriorityQueue<Integer> speedPQ = new PriorityQueue<>(k);
        for(int i = 0; i < n; i++) {
            
            if(speedPQ.size() >= k) teamSpeed -= speedPQ.remove();
            speedPQ.add(team[i][0]);
            teamSpeed += team[i][0];
            
            teamPerformance = Math.max(teamPerformance, teamSpeed * team[i][1]);
        }
        
        return (int) ((teamPerformance%M + M) %M);
    }
}