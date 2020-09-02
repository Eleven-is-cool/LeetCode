package 阿里二;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static List<String> getList(int n){
        List<String> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        while (n != 0){
            int cur = n %10;
            numList.add(cur);
            n /= 10;
        }
        int[] nums = new int[numList.size()];
        int i = 0;
        for (int digit:numList){
            nums[i++] = digit;
        }
        StringBuilder list = new StringBuilder();
        int[] visited = new int[nums.length];
        backTrack(nums, list, res, visited);
        return res;
    }
    public static void backTrack(int[] nums, StringBuilder list, List<String> res, int[] visited ){
        if (list.length() == nums.length){
            res.add(list.toString());
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 0){
                list.append(nums[i]);
                visited[i] = 1;
                backTrack(nums, list, res, visited);
                visited[i] = 0;
                list.deleteCharAt(list.length()-1);
            }
        }

    }
    public static int getNum(int m, List<String> g){
        int n = 0;
        for (String s:g){
            if ((Integer.valueOf(s))%m == 0 && s.charAt(0) != '0'){
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<String> g = getList(n);
            for (String k:g)
                System.out.println(k);
            System.out.println(getNum(m, g));
        }

    }
}