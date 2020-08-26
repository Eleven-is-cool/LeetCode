package 背包问题;

class solution{
    public Integer knapsack(int W,int N,int[] wt,int[] val){
        int[][] dp = new int[N+1][W+1];
        for(int n=1;n<N+1;n++){
            for(int w=1;w<W+1;w++){
                if(w-wt[n-1] < 0){
                    dp[n][w] = dp[n-1][w];
                }
                else{
                    dp[n][w] = Math.max(dp[n-1][w-wt[n-1]] + val[n-1],
                            dp[n-1][w]);
                }
            }
        }
        return dp[N][W];
    }
}