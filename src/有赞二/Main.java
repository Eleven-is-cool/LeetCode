package 有赞二;

import java.util.Arrays;

public class Main {
    public int minMoves (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int len = nums.length;
        int mid = 0;
        int midValue = 0;
        if (len % 2 != 0){
            mid = nums.length/2;
            midValue = nums[mid];
        }

        else{
            mid = nums.length/2;
            midValue = (nums[mid]+nums[mid-1])/2;
        }
//        System.out.println(midValue);
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res += Math.abs(nums[i] - midValue);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Main().minMoves(new int[]{1,2,4}));
    }

}
