package 完全平方数;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        for (int i = 0; i < n+1; i++){
            dp[i] = i;
            for (int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
    }

}
