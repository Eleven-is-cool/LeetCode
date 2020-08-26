package 爱奇艺三;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
判断字符串括号是否有效
时间限制： 3000MS
内存限制： 589824KB
题目描述：
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。

2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。



输入描述
一个字符串，仅包含括号'('，')'，'{'，'}'，'['，']'

输出描述
如果字符串验证有效，返回 True

如果字符串验证无效，返回 False
 */
public class Main {
    public static boolean helper(String s){
        if(s.length()==0 || s.equals(""))
            return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur) && !stack.isEmpty()){
                char pop = stack.pop();
                if(pop != map.get(cur))
                    return false;
            }
            stack.add(cur);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean res = helper(s);
            if(res)
                System.out.println("True");
            else
                System.out.println("False");


        }

    }
}
