package 搜狗三;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public long getPasswordCount (String password) {
        // write code here
        String res = "";
        HashSet<StringBuilder> set = new HashSet<>();
        for (int i=0; i<10; i++){
            helper(set, password, 1, res+i);
        }
        return set.size();
    }
    public void helper(HashSet<StringBuilder> set, String password, int index, String res){
        if (index == password.length()){
            if (!res.equals(password)){
                set.add(new StringBuilder(res));
            }
            return;
        }
        double v = ((res.charAt(res.length()-1)-'0') +  (password.charAt(index)-'0'))/2.0;
        if (v-(int)v>0){
            helper(set, password, index+1, res+(int)Math.ceil(v));
            helper(set, password, index+1, res+(int)Math.floor(v));
        }else {
            helper(set, password, index+1, res+(int)(Math.ceil(v)));
        }
    }
    public static void main(String[] args) {
        System.out.println(new Main().getPasswordCount("012"));
    }


}
