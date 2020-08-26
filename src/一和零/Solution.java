package 一和零;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int l=1;l<len+1;l++){
            // 计算字符串中'1'和'0'个数
            int oneNum = 0;
            int zeroNum = 0;
            char[] chars = strs[l-1].toCharArray();
            for(char c:chars){
                if(c == '1')
                    oneNum++;
                else
                    zeroNum++;
            }
            for(int i=0;i<m+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i>=zeroNum && j>=oneNum){
                        dp[l][i][j] = Math.max(dp[l-1][i][j], dp[l-1][i-zeroNum][j-oneNum]+1);
                    }
                    else
                        dp[l][i][j] = dp[l-1][i][j];
                }
            }
        }
        return dp[len][m][n];
    }
}