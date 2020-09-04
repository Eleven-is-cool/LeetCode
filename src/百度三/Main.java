package 百度三;

import java.util.Scanner;

public class Main {
    public int helper(int[] num, int amount) {
        if(num.length==0 && amount==0)
            return 1;
        if(num.length==0)
            return 0;
        int[][] dp = new int[num.length+1][amount+1];
        for(int i=0;i<num.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<num.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j-num[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-num[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[num.length][amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i=1;i<=n;i++){
                num[i-1] = i;
            }
            System.out.println(new Main().helper(num, count));
        }
    }
}
