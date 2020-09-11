package 搜狗二;

import java.util.Scanner;

public class Main {
    public int getHouses (int t, int[] xa) {
        // write code here

        int res = 2;
        double pre = 0;
        for (int i=0; i<xa.length; i=i+2){
            double a = xa[i]-xa[i+1]/2.0;
            double b = xa[i]+xa[i+1]/2.0;
            if (Math.abs(pre-a) > t && i!=0){
                res = res+2;
            }
            if (Math.abs(pre-a) == t && i!=0){
                res = res+1;
            }
            pre = b;
        }
        return res;

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int count = sc.nextInt();
//            int n = sc.nextInt();
//            int[] num = new int[n];
//            for (int i=1;i<=n;i++){
//                num[i-1] = i;
//            }
//            System.out.println();
//        }
        System.out.println(new Main().getHouses(2, new int[]{-4,2,1,3}));
    }
}
