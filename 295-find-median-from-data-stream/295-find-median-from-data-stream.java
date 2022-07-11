class MedianFinder {
    
    PriorityQueue<Integer> maxPQ, minPQ;

    public MedianFinder() {
        maxPQ = new PriorityQueue<>( (o1, o2) -> {
            return o2 - o1;
        });
        minPQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxPQ.isEmpty() || num < maxPQ.peek()) {
            maxPQ.offer(num);
            
            if(maxPQ.size() - minPQ.size() > 1) {
                minPQ.offer(maxPQ.poll());
            }
        } else {  
            minPQ.offer(num);
            
            if(minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }
        }    
    }
    
    public double findMedian() {
        if( ((minPQ.size() + maxPQ.size()) &1) != 0 ) return maxPQ.peek();
        else {
            double median = minPQ.peek() + maxPQ.peek();
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */