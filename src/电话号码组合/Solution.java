package 电话号码组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if(digits.equals(""))
            return res;
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder temp = new StringBuilder();
        backTrack(digits, map, temp, 0);
        return res;
    }
    public void backTrack(String digits, String[] map, StringBuilder temp, int index){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }
        Character c = digits.charAt(index);
        String letter = map[c-'0'];
        for (int i = 0; i < letter.length(); i++){
            temp.append(letter.charAt(i));
            backTrack(digits, map, temp, index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
