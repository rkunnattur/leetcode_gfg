class Solution {
    public int fib(int n) {
        
        return fibTopDownExtraSpace(n);
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
}