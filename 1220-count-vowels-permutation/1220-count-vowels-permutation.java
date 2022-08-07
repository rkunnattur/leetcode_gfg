class Solution {
    public int countVowelPermutation(int n) {
        
        return computeVowelCountI(n);
    }
    
    public int computeVowelCountI(int n) {
        long counta = 1, counte = 1, counti = 1, counto = 1, countu = 1;
        long M = (int) (1e9) + 7;
        
        for(int k = 1; k < n; k++) {
            long tempa = counta, tempe = counte, tempi = counti, tempo = counto, tempu = countu;
            counta = tempe%M;
            counte = (tempa + tempi)%M;
            counti = (tempa + tempe + tempo + tempu)%M;
            counto = (tempi + tempu)%M;
            countu = tempa%M;
        }
        
        return (int) (((((counta + counte)%M + counti)%M + counto)%M + countu)%M);
    }
}