package 字符串的排列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int right = 0;
        int left = 0;
        int valid = 0;
        while (right < s2.length()) {

            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c)))
                    valid++;
            }

            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d)))
                        valid--;
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }

        }
        return false;
    }
}
