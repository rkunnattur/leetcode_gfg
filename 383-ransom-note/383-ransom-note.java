class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countChar = new int[26];
        
        for(char ch: magazine.toCharArray()) {
            countChar[ch-'a']++;
        }
        
        for(char ch: ransomNote.toCharArray()) {
            if(--countChar[ch-'a'] < 0) return false;
        }
        
        return true;
    }
}