package 网易一;

import java.util.HashSet;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int i = 0; i < b; i++){
                int x = sc.nextInt();
                String s = sc.next();
                int y = sc.nextInt();
                set.add(x);
                temp.add(y);
            }
            int res = 0;
            for (Integer t: temp){
                if (!set.contains(t))
                    res++;
            }
            System.out.println(res/2);
        }
    }
}
