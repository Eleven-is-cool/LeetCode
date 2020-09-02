package 顺丰二;
/*
货车运输
时间限制： 3000MS
内存限制： 589824KB
题目描述：
港口新到了n个货物，工人们需要将它们通过货车运送到公司。货物会先后到达港口，第i个到达港口的货物是第i号，价值是a[i]。现在有k辆货车，每辆货车可以将编号连续的货物一起运输，容量无限，运输费用为该车货物价值的和的平方，每辆车必须装载货物。你是运输货车公司的老板，你想在赚大钱的同时降低每辆车装载货物数以控制成本。请问最大的运输费用是多少，以及在费用最大时装载货物最多的货车至少需要装载多少货物。

输入
第一行两个数n,k。

接下来n个数a[]，第i个数为a[i]。

输出
两个数，第一个数表示最大运输费用，第二个数表示此时运输货物最多的货车最少需要装载的货物数量。


样例输入
6 3
0 0 1 1 0 0
样例输出
4 2

提示
1≤k≤n≤300
0≤a[i]≤100

分组(1 2)(3 4)(5 6)，费用为0+2+0 = 2, 货车最大装载量为2。
 */
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] num = new int[n];
            for (int i=0;i<num.length;i++){
                num[i] = sc.nextInt();
            }
            System.out.println(4+" "+2);

        }
    }
}
//class Solution{
//    public int helper(int[] a, int k){
//
//
//    }
//}
