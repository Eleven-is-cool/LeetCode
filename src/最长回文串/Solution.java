package 最长回文串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        int res = 0;
        boolean signal = false;
         for (Map.Entry<Character, Integer> entry : map.entrySet()){
             res += entry.getValue()/2*2;
             if (entry.getValue()-entry.getValue()/2*2>0){
                 signal = true;
             }
         }
         if(signal)
             res++;
         return res;


    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
    }
}
