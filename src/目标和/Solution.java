package 目标和;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int target = 0;
        for(int n:nums)
            target += n;
        if (target < Math.abs(S) || (target+S)%2!=0)
            return 0;
        target += S;
        target /= 2;
        int[][] dp = new int[nums.length+1][target+1];
        // 不用元素也能凑成target=0
        dp[0][0] = 1;
        for(int i=1;i<nums.length+1;i++){
            // 目标有可能是0，区别于其他背包问题
            for(int j=0;j<target+1;j++){
                if(j-nums[i-1] >= 0)
                    //dp[i-1][j-nums[i-1]]前面一维索引是i-1，是因为只能拿一次这个数，即0-1背包问题。
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][target];
    }
}