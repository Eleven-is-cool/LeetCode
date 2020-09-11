package 腾讯二;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<HashSet> list = new ArrayList<>();
            HashSet<Integer> res = new HashSet<>();
            for (int i = 0; i < m; i++){
                int x = sc.nextInt();
                HashSet<Integer> set = new HashSet<>();
                for (int xx = 0; xx < x; xx++){
                    int k = sc.nextInt();
                    set.add(k);
                }
                if (set.contains(0)){
                    for (Integer a:set)
                        res.add(a);
                }
                list.add(set);
            }
            int pre = 0;
            while (pre != res.size()){
                pre = res.size();
                for (int i = 0; i < list.size(); i++){
                    HashSet<Integer> set =  list.get(i);
                    for (Integer a:res){
                        if (set.contains(a)){
                          for (Integer x:set)
                            res.add(x);
                        }
                    }
                }
            }

            System.out.println(res.size());
        }
    }

}
