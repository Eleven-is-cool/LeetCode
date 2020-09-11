package 哔哩哔哩二;

import java.util.Scanner;

public class Main {
    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[] res = new int[len1*len2];
        int left = 0;
        int right = len2-1;
        int up = 0;
        int down = len1-1;
        int k = 0;
        while (true){
            for (int i = left; i <= right; i++){
                res[k++] = matrix[up][i];
            }
            up++;
            if (up > down)
                break;

            for (int i = up; i <= down; i++){
                res[k++] = matrix[i][right];
            }
            right--;
            if (right < left)
                break;

            for (int i = right; i >= left; i--){
                res[k++] = matrix[down][i];
            }
            down--;
            if (down < up)
                break;

            for (int i = down; i >= up; i--){
                res[k++] = matrix[i][left];
            }
            left++;
            if (left > right)
                break;
        }
        return res;

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
////            System.out.println(new 哔哩哔哩一.Main().helper(num));
//        }

        System.out.println(new Main().SpiralMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
