class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length(), hash = 0;
        Map<Integer, Integer> seqMap = new HashMap<>(); // to store freq of occurence
        List<String> duplicates = new ArrayList<>(); // to store dup, that occur more than once
        final int TEN = 10;
        if(len < TEN) return duplicates; // seq is 10 letter long, so if input < 10 return empty list
        
        for(int i = 0; i < TEN; i++) {
            hash <<= 2; // apply rolling hash
            hash |= getId(s.charAt(i)); // or it with next char
            hash &= 0xfffff; // & it to remove right mosty char
        }
        
        seqMap.put(hash, 1); 
        
        for(int i = TEN; i < len; i++) {
            hash <<= 2;
            hash |= getId(s.charAt(i));
            hash &= 0xfffff;
            
            int occ = seqMap.getOrDefault(hash, 0);
            if(occ == 1) { // if occ == 1, add to duplicates
                duplicates.add(s.substring(i-TEN+1, i+1));
            }
            
            seqMap.put(hash, seqMap.getOrDefault(hash, 0)+1); // else incr freq
        }
        
        return duplicates;
    }
    
    public int getId(char c){
        if(c == 'A') return 0;
        if(c == 'C') return 1;
        if(c == 'G') return 2;
        if(c == 'T') return 3;
        else return -1;
    }
}