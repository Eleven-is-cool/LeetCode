package 百度一;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public int helper(int[] num){
        StringBuilder list = new StringBuilder();
        int max = 0;
        int[] visited = new int[num.length];
        backTrack(num,  list, max, visited);
        return max;
    }
    public void backTrack(int[] num, StringBuilder list, int max, int[] visited){
//        System.out.println(list.toString());
//        if (list.length()>0)
//            System.out.println(Integer.valueOf(list.toString()));
//        System.out.println(list);
//        int res = 0;
//        for (Integer a:list){
//            res = res *10 +a;
//        }
        int res = 0;
        if (list.length()<=10 && list.length() != 0)
            res = Integer.parseInt(list.toString());
//        System.out.println(res);
        if (res<Integer.MAX_VALUE && res % 90 == 0 && res!=0){
            System.out.println(res);
            max = Math.max(max, res);
//            System.out.println(max);
        }
        for (int i = 0; i < num.length; i++){
            if (visited[i] == 1)
                continue;
            if (i-1>0 && visited[i-1]==1 && num[i]==num[i-1])
                continue;
            list.append(num[i]);
            visited[i] = 1;
            backTrack(num, list, max, visited);
            visited[i] = 0;
            list.deleteCharAt(list.length()-1);
        }
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] num = new int[n];
//            for (int i = 0; i < n; i++){
//                num[n] = sc.nextInt();
//            }
//
//            System.out.println(new Main().helper(num));
//        }
//
        System.out.println(new Main().helper(new int[]{5,5,5,5,5,5,5,5,0,5,5}));

    }

}
