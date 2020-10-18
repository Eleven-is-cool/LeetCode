package 同城三;

import java.util.HashSet;
import java.util.Scanner;

public class Main {


    public int firstMissingPositive (int[] nums) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        int res = nums[0];
        for (int n: nums)
            set.add(n);
        int start = 1;
        while (true){
            if (set.contains(start)){
                start++;
            }else {
                return start;
            }
        }
    }
}
