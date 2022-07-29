class Solution {
    public int minDistance(String word1, String word2) {
        
        return computeMinDistanceI(word1, word2);
    }
    
    public int computeMinDistanceR(String word1, String word2) {
        return 0;
    }

    public int computeMinDistanceI(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        
        int[][] editDist = new int[len1+1][len2+1];
        
        for(int idx = 0; idx <= len1; idx++) 
            editDist[idx][0] = idx;
        
        for(int idx = 0; idx <= len2; idx++) 
            editDist[0][idx] = idx;
        
        
        for(int r = 1; r <= len1; r++) {
            for(int c = 1; c <= len2; c++){
                if(word1.charAt(r-1) == word2.charAt(c-1)) editDist[r][c] = editDist[r-1][c-1];
                else {
                    editDist[r][c] = 1 + Math.min(editDist[r][c-1], Math.min(editDist[r-1][c], editDist[r-1][c-1]));
                }
            }
        }
        
        return editDist[len1][len2];
    }
}