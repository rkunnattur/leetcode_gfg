class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums; // ed=ge case
        
        // create class with val n freq of val 
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) +1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return freqMap.get(o1) - freqMap.get(o2);
        });
        for(int val: freqMap.keySet()) {
            
            if(pq.size() >= k && freqMap.get(val) >= freqMap.get(pq.peek())) {
                pq.poll();
                pq.offer(val);
            } else if(pq.size() < k) pq.offer(val);
        }
        
        return pq.stream().mapToInt(n -> n).toArray();
    }
}
