class Solution {
    public int firstUniqChar(String s) {
        int len = s.length(), firstNonRepeatingCharIdx = -1;
        Map<Character, Integer> charFreq = new HashMap<>();
        for(int st = 0, e = 0; st < len && e <= st; st++) {
            char ch = s.charAt(st);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1); 
            
            while(e <= st && charFreq.getOrDefault(s.charAt(e), 0)  > 1) {
                e++;
            }
            
            firstNonRepeatingCharIdx = e;
        }
        
        return firstNonRepeatingCharIdx >= len ? -1 : firstNonRepeatingCharIdx;
    }
}