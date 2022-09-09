class Solution {
    
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        
         /*Arrays.sort(properties, (o1, o2) -> {
            if(o1[0] != o2[0]) ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]);
        }); */
        
        Arrays.sort(properties, (int[] o1, int[] o2) -> {
            return (o1[0] != o2[0]) ? o1[0] - o2[0] : o2[1] - o1[1];
        }); 
        
       /* Arrays.sort(properties, (int[] o1, int[] o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]); */
        
        int max = properties[len-1][1], noOfWeakChar = 0;
        for(int i = len-2; i >= 0; i--) {
            if(properties[i][1] < max) noOfWeakChar++;
            else max = properties[i][1];
        }
        
        return noOfWeakChar;
    }
}