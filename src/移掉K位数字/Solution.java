package 移掉K位数字;

import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(char digit:num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peekLast()>digit){
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        for(int i=0;i<k;i++){
            stack.removeLast();
        }

        StringBuilder res = new StringBuilder();
        boolean front = true;
        for(char digit:stack){
            if(front && digit == '0')
                continue;
            front = false;
            res.append(digit);
        }
        if(res.length() == 0)
            return  "0";
        return res.toString();
    }
}
