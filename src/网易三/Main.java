package 网易三;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] list = new int[a-1];
            for (int i = 0; i < a-1; i++){
                list[i] = sc.nextInt();
            }
            System.out.println(a-2);
        }
    }
}
