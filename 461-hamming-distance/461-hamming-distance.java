class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int hammingDistance = 0;
        while (xor != 0) {
          if ((xor&1) == 1)
            hammingDistance += 1;
          xor = xor >> 1;
        }
        
        return hammingDistance;
    }
}