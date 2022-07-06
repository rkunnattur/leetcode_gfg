class Solution {
    public int fib(int n) {
        
        return fibTopDownNoExtraSpace(n);
    }
    
    public int fibTopDownExtraSpace(int n) {
        if(n <= 1) return n;
        
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        
        return fib[n];
    }
    
    public int fibTopDownNoExtraSpace(int n) {
        if(n <= 1) return n;
        
        int prev_2 = 0, prev_1 = 1, curr = 0;
        for(int i = 2; i <= n; i++) {   
            curr = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = curr;
        }
        
        return curr;
    }
}