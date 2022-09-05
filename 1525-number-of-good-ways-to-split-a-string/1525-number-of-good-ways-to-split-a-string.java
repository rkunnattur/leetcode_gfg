class Solution {
    
    
    /* Approach1: sliding window technique, with left n right preffixx arrays
        */
    
    public int numSplits1(String s) {
        int slen = s.length(), rightCount = 0;
        int[] prefixRightCount = new int[s.length()];
        
        for(int i = 0; i < slen; i++) {
            if(++prefixRightCount[(s.charAt(i) - 'a')] == 1) {
                rightCount++;
            } 
        }
        
        int[] prefixLeftCount = new int[s.length()];
        int leftCount = 0, goodSplitCount = 0;
        for(int i = 0; i < slen; i++) {
            if(--prefixRightCount[s.charAt(i) - 'a'] == 0) rightCount--;
            if(++prefixLeftCount[s.charAt(i) - 'a'] == 1) leftCount++;
            
            if(leftCount == rightCount) goodSplitCount++;
        }
        
        return goodSplitCount;
    }
    
    //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/discuss/2340113/.Explanation-and-ways-of-approaching-similar-kind-of-problems
    
    /*
        Approach2: slidingWindow Technique, withh preffix Array n HashSet
    */
     public int numSplits(String s) {
         int len = s.length();
         
         int[] prefix = new int[len];
         Set<Character> distinctChar = new HashSet<>();
         for(int i = len-1; i >= 0; i--) {
             prefix[i] = distinctChar.size();   
             distinctChar.add(s.charAt(i)); // count of distinct char
         }
         
         distinctChar.clear();
         int goodSplit = 0;
         for(int i = 0; i < len; i++) {
             distinctChar.add(s.charAt(i));
             if(distinctChar.size() == prefix[i]) goodSplit++;
         }
         
         return goodSplit;
     }
    
}