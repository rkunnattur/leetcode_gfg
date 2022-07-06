class Solution {
    Map<Integer, Integer> cache;
    
    public int fib(int n) {
        this.cache = new HashMap<>(Map.of(0, 0, 1, 1));
        return fibTopDownExtraSpace(n);
    }
    
    public int fibBottomUpExtraSpace(int n) {
        if(n <= 1) return n;
        
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        
        return fib[n];
    }
    
    public int fibBottomUpoExtraSpace(int n) {
        if(n <= 1) return n;
        
        int prev_2 = 0, prev_1 = 1, curr = 0;
        for(int i = 2; i <= n; i++) {   
            curr = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = curr;
        }
        
        return curr;
    }
    
    
    public int fibTopDownNoExtraSpace(int n) {
        if(n <= 1) return n;
        
        return fibTopDownNoExtraSpace(n-1) + fibTopDownNoExtraSpace(n-2);
    }
    
    public int fibTopDownExtraSpace(int n) {
        
        
        if(cache.containsKey(n)) return cache.get(n);
        
        cache.put(n, fibTopDownExtraSpace(n-1) + fibTopDownExtraSpace(n-2));
        return cache.get(n);
        
    }
    
}