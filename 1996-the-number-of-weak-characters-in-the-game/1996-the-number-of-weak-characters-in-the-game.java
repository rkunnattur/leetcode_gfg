class Solution {
    
    public int numberOfWeakCharactersCp(int[][] properties) {
        
        // if we sort only by 1st indexes, there could be values where 1st index is the same 
        // Arrays.sort(properties, (a,b) -> Integer.compare(a[0], b[0]));
        
        // b[1], a[1] because we need the 2nd values in descending order
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        
        for(int[] prop: properties) System.out.printf(Arrays.toString(prop));
        
        int noOfWeakCharacters = 0;
        int len = properties.length;
       // improvization here - // we need to keep track of the max value
        int max = properties[len-1][1];
        
        for(int i = len-2; i>=0 ;i--) {
            
            if(properties[i][1] < max) {
                noOfWeakCharacters++;
            } else {
                max = properties[i][1];
            }
        }
        return noOfWeakCharacters;
    }
    
    
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        
         /*Arrays.sort(properties, (o1, o2) -> {
            if(o1[0] != o2[0]) ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]);
        }); */
        
        Arrays.sort(properties, (int[] o1, int[] o2) -> {
            return (o1[0] != o2[0]) ? o1[0] - o2[0] : o2[1] - o1[1];
        }); 
        
        for(int[] prop: properties) System.out.printf(Arrays.toString(prop));
        
       /* Arrays.sort(properties, (int[] o1, int[] o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]); */
        
        int max = properties[len-1][1], noOfWeakChar = 0;
        for(int i = len-2; i >= 0; i--) {
            if(properties[i][1] < max) noOfWeakChar++;
            else max = properties[i][1];
        }
        
        return noOfWeakChar;
    }
}