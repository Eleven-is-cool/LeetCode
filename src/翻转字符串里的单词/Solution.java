package 翻转字符串里的单词;

class Solution {
    public static String reverseWords(String s) {
        s.trim();
        StringBuilder res = new StringBuilder();
        int i=s.length()-1;
        int j=s.length()-1;
        while(i >= 0){
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            res.append(s.substring(i+1, j+1) + " ");
            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;

        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
