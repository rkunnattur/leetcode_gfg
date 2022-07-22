class Solution {
    public int fib(int n) {
        
        //return fibTopDown(n);
        return fibBottomUp(n);
    }
    
    public int fibTopDown(int n) {
        // return fibRNoExSp(n);
        int[] fib = new int[n+1];
        Arrays.fill(fib, -1);
        fib[0] = 0; fib[1] = 1;
        
        return fibRExSp(n, fib);
    }
    
    public int fibBottomUp(int n) {
        
        //return fibIExSp(n);
        return fibINoExSp(n);
    }
    
     public int fibINoExSp(int n) {
         if(n <= 1) return n;
         int prevprev = 0, prev = 1, curr = prev + prevprev;
         
         for(int i = 2; i <= n; i++) {
             curr = prevprev + prev;
             prevprev = prev;    
             prev = curr;
         }
         
         return curr;
     }
    
    public int fibIExSp(int n) {
        int[] fib = new int[n+1];
        fib[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        
        return fib[n];
    }
    
    public int fibRNoExSp(int n){
        if(n <= 1) return n;
        
        return fibRNoExSp(n-1) + fibRNoExSp(n-2);
    }
    
    public int fibRExSp(int n, int[] fib) {
        if(fib[n] != -1) return fib[n];
        
        fib[n] = fib[n-1] + fib[n-2];
        return fib[n];
    }
}