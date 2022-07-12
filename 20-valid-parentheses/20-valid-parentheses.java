class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> charMap = Map.of(')', '(', '}', '{', ']', '[');
        
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(charMap.containsKey(ch)) {
                if(st.isEmpty() || st.pop() != charMap.get(ch)) return false;        
            } else st.push(ch);
        }
        
        return st.isEmpty();
    }
}