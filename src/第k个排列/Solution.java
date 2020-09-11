package 第k个排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        String list = "";
        int[] visited = new int[n+1];
        backTrack(res, list, n, k, visited);
        return res.get(k-1).toString();
    }

    public void backTrack(List<String> res, String list, int n, int k, int[] visited){
//        System.out.println(res);
        if (list.length() == n){
            res.add(list);
            System.out.println(res);
            System.out.println(list);
            return;
        }
        for (int i = 1; i <= n; i++){
            if (visited[i] == 1)
                continue;
//            list.append(i);
            visited[i] = 1;
            backTrack(res, list+i, n, k, visited);
            visited[i] = 0;
//            list.deleteCharAt(list.length()-1);
        }
//        System.out.println(res);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3,3));
    }

}
