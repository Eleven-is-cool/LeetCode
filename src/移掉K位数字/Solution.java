package 移掉K位数字;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++){
            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()){
                stack.pop();
                k = k - 1;
            }
            stack.add(num.charAt(i));
        }
        for (int j = 0; j < k; j++){
            stack.pop();
        }
        StringBuilder res = new StringBuilder();
        boolean firstZero = true;
        for (Character s: stack){
            if (firstZero && s == '0')
                continue;
            firstZero = false;
            res.append(s);
        }
        if (res.length() == 0)
            return "0";
        return res.toString();
    }
}
