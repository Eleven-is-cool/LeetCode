package 最短回文串;

public class Solution {
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left)  != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String shortestPalindrome(String s) {
        int len = s.length();
        for (int i = len; i>=0; i--){
            String prefix = s.substring(0, i);
            System.out.println(prefix);
            if (isPalindrome(prefix)){
                System.out.println(s.substring(i));
                // 去掉回文部分
                StringBuilder add = new StringBuilder(s.substring(i)).reverse();
                return add + s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("banana"));
    }
}
