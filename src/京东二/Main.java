package 京东二;
/*
题目
时间限制： 3000MS
内存限制： 589824KB

题目描述：
某滚球游戏规则如下：球从入口处（第一层）开始向下滚动，每次可向下滚动一层，
直到滚至最下面一层为止。球每次可滚至左下、下方或右下三个方格中的任意一个，每个方格都有一个得分，
如下图所示。第1层有1个方格，第2层有3个方格，……，以此类推，第n层有2*n-1个方格。
设计一个算法，使得球从入口滚至最下面一层的总得分和最大。
![image](https://uploadfiles.nowcoder.com/images/20200827/532408814_1598536945025_B8D4F2BC5BE0C7E56AD382EA95C9DA1E)


输入描述
第1行的正整数n表示数字三角形的层数。（n<=100)

接下来n行包含一个数字三角形，每一行包含2n-1个方格，对应有2n-1个表示得分的正整数（不超过10^5），每两个数字之间用空格隔开。

输出描述
球从入口（第一层）滚至最下面一层的最大得分和。

样例输入
3
1
2 1 2
3 4 2 1 3

样例输出
7
 */
import java.util.*;
public class Main {
    static int max = 0;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][2 * n-1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2 * i -1; j++) {
                map[i-1][j-1] = sc.nextInt();
            }
        }
        dfs(0,0,0,n);
        System.out.println(max);
    }
    private static void dfs(int i, int j, int sum,int n) {
        if(i == n) max = Math.max(max,sum);
        else{
            for(int k = 0; k < 3; k++) {
                dfs(i+1,j+k,sum + map[i][j],n);
            }
        }
    }
}
