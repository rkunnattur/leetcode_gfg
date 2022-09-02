class Solution {
    public int[] countBits(int n) {
        int[] countOfBits = new int[n+1];
        
        for(int a = 0, i = 0; a <= n && i <= n; a++, i++) {
            int countBits = 0;
            int x = a;
            while(x != 0) {
                x &= x-1;
                
                countBits++;
            }
            
            countOfBits[i] = countBits;
        }
        
        return countOfBits;
    }
}