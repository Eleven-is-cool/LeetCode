package 递增子序列;

import java.util.*;

public class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, 0);
        return new ArrayList<>(res);
    }
    public void backtrack(int[] nums, List<Integer> list, int start){
        if (list.size() >= 2){
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i  < nums.length; i++){
            if(list.isEmpty() || nums[i] >= list.get(list.size()-1)){
                list.add(nums[i]);
                backtrack(nums, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {1,3,5,7};
        System.out.println(s.findSubsequences(input));
    }
}
