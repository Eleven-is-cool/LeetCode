package 广联达二;

import java.util.Scanner;

public class Main {
    public int helper(int A, int B, int C, int D){
        int target = (A + B + C + D) / 4;
        for (int i = target; i >= 0; i--) {
            int needA = Math.max(i - A, 0);
            int needB = Math.max(i - B, 0);
            int needC = Math.max(i - C, 0);
            int needD = Math.max(i - D, 0);
            int need = needA + needB + needC+ needD;
            if (need <= target*4 - i*4)
                return i*4;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            System.out.println(new Main().helper(A, B, C, D));
        }
    }
}
