package 小米一;

/**
 密码生成器
 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。

 可以一次输入多组密码，以空格符间隔，空格符不作为密码。



 输入描述
 需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分

 输出描述
 每个密码的检查结果，每个结果需要换行输出


 样例输入
 123 12345678 123abcABC!!!
 样例输出
 1
 2
 0

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public int helper(String s){
        HashSet<Integer> type = new HashSet<>();
        if (!(s.length() >=8 && s.length()<=120))
            return 1;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= '0' && s.charAt(i)<='9'){
                type.add(1);
            }

            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                type.add(2);
            }

            else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                type.add(3);
            }

            else{
                type.add(4);
            }

        }
        if (type.size() == 4)
            return 0;
        else
            return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
//            System.out.println(string);
            List<StringBuilder> list = new ArrayList<>();
            int j = 0;
            int i = 0;
            while (j < string.length()){
                while (j < string.length() && string.charAt(j) != ' '){
                    j++;
                }
//                System.out.println(string.substring(i, j));
                list.add(new StringBuilder(string.substring(i, j)));
                while (j < string.length() && string.charAt(j) == ' '){
                    j++;
                }
                i = j;
            }

            for (StringBuilder s:list){
//                System.out.println(s);
                System.out.println(new Main().helper(s.toString()));
            }

//            System.out.println();
        }
    }
}
