package 预测赢家;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int helper(int[][] visited, int[] nums, int i, int j){
        if (i == j)
            return nums[i];
        if (visited[i][j] != 0)
            return visited[i][j];
        int pickI = nums[i] - helper(visited, nums, i+1, j);
        int pickJ = nums[j] - helper(visited, nums, i, j-1);
        visited[i][j] = Math.max(pickI, pickJ);
        return visited[i][j];
    }
    public boolean PredictTheWinner(int[] nums) {
        int[][] visited = new int[nums.length][nums.length];
        return helper( visited, nums, 0 ,nums.length-1)>=0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[]{1,5,2}));
    }
}
