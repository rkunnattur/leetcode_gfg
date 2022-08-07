class Solution {
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
}