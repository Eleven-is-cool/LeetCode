package 整数因子分解解法总数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int total = 0;
    public void getAns(int n, List<Integer> list, List<List<Integer>> res){
        if (n == 1){
            total++;
            res.add(new ArrayList<>(list));
        }
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                // 如果有要求顺序不一致是同种解法，需要加下面注释代码进行判断
//                if (list.size() > 0 && i < list.get(list.size()-1))
//                    continue;
                list.add(i);
                getAns(n/i, list, res);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        new Solution().getAns(12, list, res);
        // 因子分解解法总数
        System.out.println(res.size());
        // 因子分解解法
        System.out.println(res);
    }
}
