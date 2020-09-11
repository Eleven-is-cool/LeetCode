package 搜狗一;

import java.util.Scanner;

public class Main {
    public int numberofprize (int a, int b, int c) {
        // write code here
        if (a==b && b==c)
            return a;
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;

        int aTemp = a - min;
        int bTemp = b - min;
        int cTemp = c -min;
        int sum = (aTemp*2+bTemp*2+cTemp*2)/3;
        int v = sum/3;
        return min+v;
    }

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
