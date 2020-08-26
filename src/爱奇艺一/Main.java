package 爱奇艺一;
/*
n的阶乘问题
时间限制： 3000MS
内存限制： 589824KB
题目描述：
正整数n的阶乘(n!)中的末尾有多少个0?

例如：n = 5, n! = 120.末尾有1个0

实现：int CountZero(int n);



输入描述
一个正整数

输出描述
一个自然数


样例输入
31
样例输出
7
 */
import java.util.Scanner;

public class Main {
    public static  int CountZero(int n){
        int res = 0;
        // n! = 1 * 2 * 3 * 4 * (1 * 5) * ... * (2 * 5) * ... * (3 * 5) *... * n
        // 为什么选5是因为出现0结尾就是有2*5相乘，2太多了，选5
        // 看n能被多少个5整除，25有两个5，125有三个五
        while(n > 0){
            n = n/5;
            res = res + n;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(CountZero(n));
        }
    }
}
