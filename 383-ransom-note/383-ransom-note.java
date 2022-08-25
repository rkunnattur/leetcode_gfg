class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[][] countChar = new int[26][26];
        
        for(char ch: magazine.toCharArray()) {
            countChar[0][ch-'a']++;
        }
        
        for(char ch: ransomNote.toCharArray()) {
            countChar[1][ch-'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
            if(countChar[1][i] > 0 && countChar[1][i] > countChar[0][i]) return false;
        }
        
        return true;
    }
}