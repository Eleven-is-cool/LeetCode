package 正则表达式匹配;

// 动态规划
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (p.length() == 0)
            return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        // 这一步多余，只是为了清除说明
        dp[0][1] = false;
        // 初始化s为零个字符串的时候
        for (int i = 2; i < p.length() + 1; i++){
            dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-2];
        }

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                // 有'*'，分两种情况：1. *前字母零个匹配 2.*前字母先匹配一个
                if (p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || (isMatch(s, i, p, j-1) && dp[i][j + 1]);
                }
                else {
                    dp[i + 1][j + 1] = isMatch(s, i, p, j) && dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public boolean isMatch(String s, int i, String p, int j){
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }

}
