package 逆波兰表达式求值;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens){
            if (token.equals("+")){
                stack.addLast(stack.removeLast() + stack.removeLast());
            }else if (token.equals("*")){
                stack.addLast(stack.removeLast() * stack.removeLast());
            }else if (token.equals("-")){
                Integer cur = stack.removeLast();
                stack.addLast(stack.removeLast() - cur);
            }else if (token.equals("/")){
                Integer cur = stack.removeLast();
                stack.addLast(stack.removeLast() / cur);
            }else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.removeLast();

    }
}
