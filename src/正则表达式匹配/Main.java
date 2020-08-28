package 正则表达式匹配;

public class Main {
    // 递归
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        // 查看第一位是否匹配：字符相等或者有'.'，则匹配
        boolean fistMatch;
        if (!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0) == '.'))
            fistMatch = true;
        else
            fistMatch = false;
        // 有'*'，分两种情况：1. *前字母零个匹配 2.*前字母先匹配一个
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (fistMatch && isMatch(s.substring(1), p));
        else
            return (fistMatch && isMatch(s.substring(1), p.substring(1)));
    }

}
