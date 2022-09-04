class Solution {
    public int numSplits(String s) {
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
}