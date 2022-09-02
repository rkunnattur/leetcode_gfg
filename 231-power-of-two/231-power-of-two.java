class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        long x = n; // if huge negative number, conversion to long helps
        return (x & (x-1)) == 0;
    }
}