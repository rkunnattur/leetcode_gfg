class Solution {
    
    public int romanToInt(String s) {
       Map<Character, Integer> numericalRepresentation = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        
        int sum = 0, prev=0, temp = 0;
        for(int i = s.length()-1; i >=0; i--) {
            temp = numericalRepresentation.get(s.charAt(i));
            sum += (temp < prev) ? (-1 * temp) : temp;
            prev = temp;
        }
        
        return sum;
    }
}