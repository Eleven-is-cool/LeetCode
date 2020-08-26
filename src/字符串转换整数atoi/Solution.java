package 字符串转换整数atoi;

public class Solution {
    public int myAtoi(String str){
        int len = str.length();
        int index = 0;
        while (index < len){
            if(str.charAt(index) == ' ')
                break;
            index++;
        }
        if (index == len)
            return 0;
        int flag = 1;
        if(str.charAt(index) == '+'){
            flag = 1;
            index++;
        } else if (str.charAt(index) == '-'){
            flag = -1;
            index++;
        }
        int res = 0;
        while (index < len){
            char cur = str.charAt(index);
            if (cur>'9' || cur<'0')
                break;
            if (res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 &&
                    (cur-'0')>7))//7是2^31 - 1的个位数
                return Integer.MAX_VALUE;
            if (res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 &&
                    (cur-'0')>8))//8是-2^31的个位数
                return  Integer.MIN_VALUE;

            res = res*10 + (cur-'0');
            res = flag*res;
            index++;
        }
        return res;
    }
}
