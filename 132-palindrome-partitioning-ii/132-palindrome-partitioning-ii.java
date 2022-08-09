class Solution {
    public int minCut(String s) {
        int n = s.length(), min = 0;
        
        /* represents String i to j is a palindrome or not
        */
        boolean[][] isPalindrome = new boolean[n][n];
        /* mincut[i] represents minimum number of cuts from String 0 to i
        */
        int[] mincut = new int[n];
        /* iterates the full string */
        for(int i = 0; i < n; i++) { // col traversal
            min = i; // Max number of cuts is i for string length i+1
            /* iterates string till ith index for palidrome check */
            for(int j = 0; j <= i; j++) { // row traversal
                    /*  
                    Why i - j < 3  ?
                        1. String of length 1 is always palindrome so no need to check in boolean table
                        2. String of length 2 is palindrome if Ci == Cj which is already checked in first part so no need to check again
                        3. String of length 3 is palindrome if Ci == Cj which is already checked in first part and Ci+1 and Cj-1 is same character which is always a palindrome
            
                        If String length >=4, then check if Ci == Cj and if they are equal check if String[j+1 .. i-1] is a palindrome from the boolean table
                */
                if(s.charAt(j) == s.charAt(i) && (i - j < 3 || isPalindrome[j+1][i-1])) {
                    
                    /*
                        Its a palindrome as charAt(i) == charAt(j) and String[j+1...i-1] is a palindrome
                    */
                    isPalindrome[j][i] = true;
                    
                    /*
                        j == 0 because String from j to i is a palindrome and it starts from first character so means no cuts needed 
                        Else I need a cut at jth location and it will be cuts encountered till j-1 + 1
                    */
                    min = j == 0 ? 0 : Math.min(min, mincut[j-1] + 1);         
                }
            }
            
            mincut[i] = min;
        }
        
        return mincut[n-1];
    }
}