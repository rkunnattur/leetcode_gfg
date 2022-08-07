class Solution {
    public int coinChange(int[] coins, int amount) {
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