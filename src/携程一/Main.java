package 携程一;


/**
 搬砖铺路
 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 天会SOHO最近正在进行道路建设，现在有充足的长度为a和长度为b的两种规格的瓷砖。

 现在从这些瓷砖中任取k块来铺路，请按递增的顺序输出所有可能的铺成道路的长度。



 输入描述
 输入为3个数，每行1个数，第一个数表示a，第二个数表示b，第三个数表示k。

 a和b均为正整数，0 <= k <= 100000

 输出描述
 输出的结果为一个数组，数组中的值从小到大排列，如：[3,4,5,6]。如果数组为空则输出为[]，如果有相同的结果去除重复的。


 样例输入
 1
 2
 3
 样例输出
 [3,4,5,6]

 提示
 可以使用 3 次 a，得到结果 3；使用 2 次 a 和 1 次 b，得到结果 4 。以此类推，得到最终结果。
 **/

import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] divingBoard(int a, int b, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<=k;i++){
            int aNum = i;
            int bNum = k-i;
            int sum = a*aNum + b*bNum;
            list.add(sum);
        }
        int[] res = new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = divingBoard(_a, _b, _k);
        String value = "[]";
        if (res != null && res.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    stringBuilder.append("[");
                }
                stringBuilder.append(res[i]);
                if (i == res.length - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
            value = stringBuilder.toString();
        }
        System.out.println(value);
    }
}
