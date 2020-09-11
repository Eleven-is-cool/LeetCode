package 腾讯四;

import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++){
                num[i] = sc.nextInt();
                temp[i] = num[i];
            }
            Arrays.sort(num);
            for (int i = 0; i < n; i++){
                int mid = n/2-1;
                if (num[mid] >= temp[i]){
                    System.out.println(num[mid+1]);
                }else{
                    System.out.println(num[mid]);
                }
            }
        }
    }
}
