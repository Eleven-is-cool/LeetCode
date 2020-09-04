package 奇安信一;

import java.util.Scanner;

public class Main {
    public int helper(int n){
        if (n > 36)
            return 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return  2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
//        return helper(n-1) + helper(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(new Main().helper(n));
        }
    }
}
