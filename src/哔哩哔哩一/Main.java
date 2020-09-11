package 哔哩哔哩一;


import java.util.Scanner;

public class Main {
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int usedK = 0;
        int max = 0;
        int left = 0;
        for (int right =0; right < arr.length; right++){
            if (arr[right] == 0)
                usedK++;
            while (usedK > k){
                if (arr[left++] == 0){

                    usedK--;
                }
            }
            max = Math.max(max, right-left);
        }
        return max;

    }

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] num = new int[n];
//            for (int i = 0; i < n; i++){
//                num[n] = sc.nextInt();
//            }
//
//
//        }
        System.out.println(new Main().GetMaxConsecutiveOnes(new int[]{}, 2));
    }
}
