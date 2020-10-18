package 滴滴一;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            int right = 0;
            int left = 0;
            StringBuilder res = new StringBuilder();

            while (left < s.length()){
                right = left + n;
//                System.out.println(left);
//                System.out.println(right);
                if (right >= s.length())
                    right = s.length();
                StringBuilder temp = new StringBuilder(s.substring(left, right));
                res.append(temp.reverse());
                left = right;
            }
            System.out.println(res);
        }
    }
}
