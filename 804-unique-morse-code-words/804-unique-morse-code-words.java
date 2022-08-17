class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder strBuilder = new StringBuilder();
            for(char w : word.toCharArray())
                strBuilder.append(arr[w-'a']);
            
            set.add(strBuilder.toString());
        }
        
        return set.size();
    }
}