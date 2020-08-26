package 零钱总换II;

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length==0 && amount==0)
            return 1;
        if(coins.length==0)
            return 0;
        //dp[i][j]代表着coins的前i个值组成j的组合数
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                //如果不使用coins[i]这个面值的硬币，凑出面额j的方法数dp[i][j]应该等于dp[i-1][j]，继承之前的结果。
                //如果使用coins[i]这个面值的硬币，那么dp[i][j]应该等于dp[i][j-coins[i-1]],coins[i-1]位移差
                //dp[i][j-coins[i-1]]前面一维索引是i，是因为可以多次拿这个数，即完全背包问题。
                if(j-coins[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }
}