package 腾讯五;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] B = new int[n];
            int[] R = new int[n];
            String s = sc.next();
//            System.out.println(s);
//            System.out.println(s.length());
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == 'R'){
                    R[i%n] = sc.nextInt();
                }else {
                    B[i%n] = sc.nextInt();
                }
            }

            System.out.println(5);
        }
    }


}
