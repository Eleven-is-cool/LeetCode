package 腾讯三;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i=1;i<=n;i++){
                num[i-1] = i;
            }
            System.out.println();
        }
    }
}
