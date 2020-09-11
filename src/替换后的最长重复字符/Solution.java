package 替换后的最长重复字符;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            map.put(c, map.getOrDefault(c, 0) + 1);
            // 取当前map中的最大值
            max = Math.max(max, map.get(c));

            if (right-left > max + k){
                char d = s.charAt(left);
                left++;
                map.put(d, map.getOrDefault(d, 0) - 1);

            }
        }
        return right - left;

    }
}
