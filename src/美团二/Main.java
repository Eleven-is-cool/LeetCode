package 美团二;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int right = 0;
            int res = 0;
            for (int i = 0; i < n; i++){
                right = i;
                while (right < n){
//                    System.out.println(nums[right]);
                    if (nums[right] >= k && right-i+1 <= m)
                        right++;
                    else
                        break;
                }
                if (right-i == m){
//                    System.out.println(right+"  "+i);
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
