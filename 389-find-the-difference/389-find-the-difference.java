class Solution {
    public char findTheDifference(String s, String t) {
        
        char findRandomChar = '\0';
        
        for(char ch: s.toCharArray()) {
            if(findRandomChar == '\0') {
                findRandomChar = ch;
            } else {
                findRandomChar ^= ch;
            }
        }
        
        for(char ch: t.toCharArray()) {
           findRandomChar ^= ch;
        }
        
        return findRandomChar;  
    }
}