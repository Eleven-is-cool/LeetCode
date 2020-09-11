package 最小覆盖子串;

import java.util.HashMap;

public class Main {

    public String minWindow(String s, String t) {
        // 窗口中只加满足条件的元素

        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int right = 0;
        int left = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0)+1);
                if (windows.get(c).equals(need.get(c)))
                    valid++;
            }
            // 这里长度不加一是因为前面已经对right进行++操作了
            while (valid == need.size()){
                if (len > right - left){
                    start = left;
                    len = right -left;
                }

                // 窗口优化和一开始窗口初始化对应，写法差不多
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (windows.get(d).equals(need.get(d)))
                        valid--;
                    windows.put(d, windows.get(d)-1);

                }
            }
        }
        return len == Integer.MAX_VALUE?"":s.substring(start, start + len);
    }
}
