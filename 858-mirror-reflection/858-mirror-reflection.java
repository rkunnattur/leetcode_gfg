class Solution {
     public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
         
        while(m * p != n * q){
            n++;
            m = n * q / p;
        }
         
        return (m % 2 == 0 && n % 2 == 1) ? 0 : (m % 2 == 1 && n % 2 == 1) ? 1 : (m % 2 == 1 && n % 2 == 0) ? 2 : -1;
    }
}