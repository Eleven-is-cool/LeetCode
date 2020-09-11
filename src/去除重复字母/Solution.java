package 去除重复字母;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sum = new char[256];
        for (char c: s.toCharArray()){
            sum[c]++;
        }
        boolean[] isInStack = new boolean[256];
        for (char c: s.toCharArray()){
            sum[c]--;
            // 如果已经在栈中则继续循环，原因是栈中的元素如果不满足条件会与其他元素比较而被出栈
            if (isInStack[c-'0'])
                continue;
            // 1. 栈是否为空
            // 2. 栈顶元素是否比当前元素大，即单调栈规则
            // 3. 删除当前元素后，后面是否还有当前元素相同的值
            while (!stack.isEmpty() && stack.peek()>c && sum[stack.peek()] != 0){
                isInStack[stack.pop()-'0'] = false;
            }
            stack.push(c);
            isInStack[c-'0'] = true;
        }
        StringBuilder res = new StringBuilder();
        for (char c: stack){
            res.append(c);
        }
        return res.toString();
    }
}
