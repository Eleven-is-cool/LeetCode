package 反转字符串中的单词III;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static  String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j < s.length()){
            while (j < s.length() && s.charAt(j) != ' '){
                j++;
            }
            StringBuilder cur = new StringBuilder(s.substring(i, j));
            sb.append(cur.reverse() + " ");
            while (j < s.length() && s.charAt(j) == ' '){
                j++;
            }
            i = j;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}