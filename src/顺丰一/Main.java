package 顺丰一;

/*
分割序列
时间限制： 3000MS
内存限制： 786432KB
题目描述：
现有一序列，长度为n，所有元素均为整数元素。序列中一些元素是确定值，另一些元素是不确定的。 你的任务是将所有不确定值的元素赋予一个正整数值，使得将整个序列分割成最少的段，每一个段都是一个等差数列。 特别的，长度为1和2的段都是等差数列。

范围

对于100%的数据，n≤100000,数据组数不会超过10，出现的数字不会超过109，且除-1外都是正整数

输入
输入包含多组数据，对每组数据第一行包含一个整数n 接下来一行n个整数，空格隔开。如果数为-1,代表该元素不确定，否则该元素为确定值，输入的是这个数的值。

输出
输出一行一个数，代表分割后最少的段数，使得每一段都是等差数列


样例输入
3
-1 -1 -1
3
-1 -1 1
3
1 -1 2
7
-1 -1 -1 4 5 1 2
样例输出
1
1
2
2

提示
可以按照以下来填这四组数据
1 1 1
1 1 1
1 1 2
1 2 3 4 5 1 2
 */
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] num = new int[n];
//            for (int i=0;i<num.length;i++){
//                num[i] = sc.nextInt();
//            }
//            System.out.println(new Solution().helper(num));
//        }
        int[] num = {1 ,-1, 2};
        System.out.println(new Solution().helper(num));

    }
}
class Solution{
    public int helper(int[] num){
        if (num.length == 1 || num.length == 2)
            return 1;
        int res = 1;
        HashMap<Integer,Integer> map = new HashMap();
        int sameNum = 1;
        for (int i = 1; i<num.length; i++){
            if (num[i] == num[i-1])
                sameNum++;
        }
        if (sameNum == num.length)
            return 1;
        int pre = 1;
        int cha = num[pre] - num[pre-1];
        for (pre = 1; pre<num.length; pre++){

            if (num[pre] == -1)
                continue;
            int cur = num[pre] - num[pre-1];
            if (cur<0 || cur > num[pre])
                continue;
            if (cur != cha){
                res++;
                cha = cur;
            }
        }
        return res;

    }
}
