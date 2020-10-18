package 美团三;

/*
填数游戏
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小团和小美正在玩一个填数游戏，这个游戏是给一个等式，其中有一些数被挖掉了，你需要向其中填数字，使得等式成立。

比如 ___+12=34，那么横线填的一定是22

现在，这个游戏到了最后一关，这一关的等式很奇特：_+_+_+...+_=n

这里可以填任意多个正整数（甚至可能是1个），只要这些数的和等于n即可。

但是，有一个额外的限制，填入的所有数必须小于等于k，大于等于1，填入的数的最大值必须大于等于d。

请你计算，有多少个不同的等式满足这些限制。由于答案可能很大，请将答案mod(998244353)后输出。



输入描述
输入包含三个数n,k,d（1≤d≤k≤n≤1000）

输出描述
输出包含一行，即方案数。


样例输入
5 3 2
样例输出
12

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public int helper(int n, int k, int d) {
        int[] candidates = new int[k];
        for (int i =1; i <= k; i++){
            candidates[i-1] = i;
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        backTrack(lists, candidates, 0, n, list, d);
        return change(n, candidates, d);
    }
    public int change(int amount, int[] coins, int d) {
        if(coins.length==0 && amount==0)
            return 1;
        if(coins.length==0)
            return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j-coins[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }
    private void backTrack(List<List<Integer>> lists, int[] candidates, int sum, int n, List<Integer> list, int d) {
        if (n < sum) {
            return;
        }
        if (n == sum) {
//            System.out.println(list);
            Collections.sort(list);
            if (list.get(list.size()-1) >= d){
                System.out.println(list);
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTrack(lists, candidates, sum + candidates[i], n , list, d);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(new Main().helper(n, k, d));
        }
    }
}
