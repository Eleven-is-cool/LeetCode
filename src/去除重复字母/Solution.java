package 去除重复字母;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        // 单调栈
        // 计算出现字符的次数，为了出栈的时候不将只有一个的元素出栈
        int[] count = new int[256];
        for (char c: s.toCharArray()){
            count[c]++;
        }
        Stack<Character> stack = new Stack<>();
        // 用来去重的
        boolean[] inStack = new boolean[256];
        for (char c: s.toCharArray()){
            // 判断除了自己前面还剩多少个相同的数字
            count[c]--;
            if (inStack[c]){
                continue;
            }
            // 单调栈思想，将前面比自己大的元素出栈
            while (!stack.isEmpty() && stack.peek()>c){
                // 只有自己时，不出栈了，“bcac”
                if (count[stack.peek()] == 0){
                    break;
                }
                // 出栈并标记为false
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
