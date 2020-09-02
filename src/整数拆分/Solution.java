package 整数拆分;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n+1; i++){
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(10));
    }

}
