class Solution {
    public int minDistance(String word1, String word2) {
        
        return minDistanceHelper(word1, word2);
    }
    
    public int minDistanceHelper(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] editDist = new int[len1+1][len2+1];
        
       return computeMinDistanceR(word1, word2, len1, len2, editDist);
       // return computeMinDistanceI(word1, word2);
    }
    
    public int computeMinDistanceR(String word1, String word2, int p1, int p2, int[][] editDist) {
        
        if(p1 * p2 == 0) return p1 + p2;
        
        if(editDist[p1][p2] != 0) return editDist[p1][p2];
        
        if(word1.charAt(p1-1) == word2.charAt(p2-1)) 
            editDist[p1][p2] = computeMinDistanceR(word1, word2, p1-1, p2-1, editDist);
        
        else {
            int insert = computeMinDistanceR(word1, word2, p1, p2-1, editDist);
            int delete = computeMinDistanceR(word1, word2, p1-1, p2, editDist);
            int replace = computeMinDistanceR(word1, word2, p1-1, p2-1, editDist);
            
            editDist[p1][p2] = 1 + Math.min(insert, Math.min(delete, replace));          
        }
        
        return editDist[p1][p2];
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
                    int insert = editDist[r][c-1];
                    int delete = editDist[r-1][c];
                    int replace = editDist[r-1][c-1];
                    
                    editDist[r][c] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        
        return editDist[len1][len2];
    }
}