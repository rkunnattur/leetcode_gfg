//https://leetcode.com/problems/poor-pigs/discuss/94273/Solution-with-detailed-explanation

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = (minutesToTest / minutesToDie) + 1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(states));
    }
}