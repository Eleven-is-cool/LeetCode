package 零钱总换;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i=0;i<amount+1;i++){
            for(int coin:coins){
                if(i-coin<0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
