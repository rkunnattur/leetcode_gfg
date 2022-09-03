public class Solution {
//     suppose we have 4 bits instead of 32 bits
//     then for eg if we have number 5 (0101) in 4 bits
//     the reverse of this is 1010 i.e start to read from 0 - 3 (0 indexed)
//     so to get first bit we will do right shift ith much time and then bitwise & with 1
//     for eg to get 0th bit 0101 >> 0 = 0101 , 0101 & 1 = 1;
//     0101 >> 1 = 010, 010 & 1 = 0
//     0101 >> 2 = 01 , 01 & 1 = 1 
//     0101 >> 3 = 0, 0 & 1 = 0
//     after getting that ith bit make that bit left shift by (3-i) times
//     after getting 1 from first step left shift 1 << (3-0) = 1000 i.e 8
//     0 << (3-1) = 0
//     1 << (3-2) = 10 i.e 2, 8+2 = 10
//     0 << (3-3) = 0
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = (n >> i) & 1;
            res = res + (bit<<(31-i));
        }
        return res;
    }
}