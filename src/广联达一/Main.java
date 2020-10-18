package 广联达一;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int helper(int[] nums, int n, int m, int x){
        Queue<Integer> queue = new PriorityQueue<>();
        int max = -1;
        for (int i = 0; i < n; i++){
            queue.add(nums[i]);
            if (max < nums[i]){
                max = nums[i];
            }
        }
        while (m > 0){
            int cur = queue.poll();
            if (m > 0 && cur + x < max){
                cur += x;
                m--;
            }
            queue.add(cur);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
            System.out.println(new Main().helper(num, n, m, x));
        }
    }
}
