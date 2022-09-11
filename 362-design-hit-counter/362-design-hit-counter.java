class HitCounter {

     TreeMap<Integer, Integer> hitcounter;
    
    public HitCounter() {
        hitcounter = new TreeMap();
    }
    
    public void hit(int timestamp) {
        Integer lastkey = hitcounter.floorKey(timestamp);
        if(lastkey != null) {
            hitcounter.put(timestamp, hitcounter.get(lastkey)+1);
        } else {
            hitcounter.put(timestamp, 1);    
        }
    }
    
    public int getHits(int timestamp) {
        Integer lastkey = hitcounter.floorKey(timestamp);
        Integer floorkey = hitcounter.floorKey(timestamp-300);
        int ans = 0;
        if(lastkey != null) {
            ans = hitcounter.get(lastkey);
        }
        if(floorkey != null) {
            ans = ans - hitcounter.get(floorkey);
        }
        return ans;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */