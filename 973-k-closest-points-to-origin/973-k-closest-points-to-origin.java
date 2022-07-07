class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });
        
        int dist = 0;
        for(int i = 0; i < points.length; i++) {
            dist = (int) Math.pow(Math.abs(0 - points[i][0]), 2)
                        +  (int) Math.pow(Math.abs(0 - points[i][1]), 2);
            if(pq.size() >= k) {
                if(dist < pq.peek()[0]) {
                    pq.poll();  
                    pq.offer(new int[] {dist, i});
                }
            } 
            else pq.offer(new int[] {dist, i});
        }
        
        int[][] kClosest = new int[k][2];
        
        int i = 0;
        while(!pq.isEmpty() && i < k) {
            kClosest[i++] = points[pq.poll()[1]];
        }
        
        for(int[] kClos: kClosest) System.out.printf("pq size: %d; kClos: %s\t", pq.size(), Arrays.toString(kClos));
        
        return kClosest;
    }
    
}
