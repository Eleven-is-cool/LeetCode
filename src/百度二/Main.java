package 百度二;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            int[] n = new int[T];
            int[] m = new int[T];
            for (int i = 0; i < T; i++){
                n[i] = sc.nextInt();
                m[i] = sc.nextInt();
            }
            for (int i = 0; i < T; i++){
                ArrayList<Integer> noList = new ArrayList<>();
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < m[i]; j++){
                    // 行数
                    int k = sc.nextInt();
                    HashSet<Integer> curSet = new HashSet<>();
                    for (int z = 0; z < k; z++){
                        int l = sc.nextInt();
                        int r = sc.nextInt();
                        for (int q = l; l <= r ; q++){
                            if (z==0)
                                set.add(q);
                            curSet.add(q);
                        }
                        for(Integer a:curSet){
                            if (set.contains(a))
                                noList.add(a);
                            else
                                noList.remove(a);
                        }
                    }
                }

            }
            ArrayList<Integer> res = new ArrayList<>();
//            for (Integer a:)

        }

    }
}
