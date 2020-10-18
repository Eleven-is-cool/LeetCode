package 同城一;

import java.util.Scanner;

public class Main {
    public int helper(int[][] nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[0].length; j++){
                if (nums[i][j] == 1){
                    res++;
                    DFS(nums, i, j);
                }

            }
        }
        return res;
    }
    public void DFS(int[][] nums, int i, int j){
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] != 1)
            return;
        nums[i][j] = 2;
        DFS(nums, i-1, j);
        DFS(nums, i+1, j);
        DFS(nums, i, j-1);
        DFS(nums, i, j+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Main().helper(nums));
        }
    }
}
