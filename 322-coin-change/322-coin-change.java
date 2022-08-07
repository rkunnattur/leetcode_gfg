class Solution {
    
    // iterative approach with sapce opt to 1D array
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] noOfCoins = new int[amount+1];
        
        Arrays.fill(noOfCoins, amount+1);
        noOfCoins[0] = 0;
        
        for(int r = 1; r <= amount; r++){
            for(int c = 0; c < len; c++) {
                if(r >= coins[c]) 
                    noOfCoins[r] = Math.min(noOfCoins[r], noOfCoins[r - coins[c]]+1);
            }
        }
        
        return noOfCoins[amount] > amount ? -1 : noOfCoins[amount];
    }
    
    // iterative approach with extra space
    public int coinChangeI(int[] coins, int amount) {
        int len = coins.length;
        int[][] noOfCoins=new int[len+1][amount+1];
        
        
        for(int c = 0; c <= amount; c++) noOfCoins[0][c] = amount+1;
        
            for(int r = 1;r <= len; r++){
                for(int c = 1; c <= amount; c++){
                    noOfCoins[r][c] = noOfCoins[r-1][c];
                    if(c >= coins[r-1]){
                        noOfCoins[r][c] 
                            = Math.min(noOfCoins[r][c], noOfCoins[r][c-coins[r-1]]+1);
                    }
            }
        }
        
        return noOfCoins[len][amount] > amount ? -1 : noOfCoins[len][amount];
    }
}