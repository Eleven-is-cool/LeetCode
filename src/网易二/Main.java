package 网易二;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int helper(String s){
        if (s.length() == 1 && !s.equals("a") && !s.equals("b")
                && !s.equals("c") && !s.equals("x") && !s.equals("y")&& !s.equals("z"))
            return 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int max = 0;
        for (int i = 0; i < s.length()-1; i++){
            for (int j = i+1; j < s.length(); j++){
//                System.out.println(s.substring(i, j+1));
//                System.out.println(j-i+1);
                for (int k = 0; k < j-i+1; k++){
                    if (s.substring(k).equals("a"))
                        a++;
                    else if (s.substring(k).equals("b"))
                        b++;
                    else if (s.substring(k).equals("c"))
                        c++;
                    else if (s.substring(k).equals("x"))
                        x++;
                    else if (s.substring(k).equals("y"))
                        y++;
                    else if (s.substring(k).equals("z"))
                        z++;
                }
                if (a%2 == 0 &&
                        b%2 == 0 &&
                        c%2 == 0 &&
                        x%2 == 0 &&
                        y%2 == 0 &&
                        z%2 == 0){
                    max = Math.max(max, j-i+1);
//                    System.out.println(max);
                }

            }
        }
        return max;
    }
    public int helperString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int right = 0;
        int[] dp = new int[6];
        for (int i = 0; i < 6; i++)
            dp[i] = -1;
        int max = 0;
        while (right < s.length()){
            char k = s.charAt(right);
            if (k == 'a')
                a++;
            else if (k == 'b')
                b++;
            else if (k == 'c')
                c++;
            else if (k == 'x')
                x++;
            else if (k == 'y')
                y++;
            else if (k == 'z')
                z++;
            a %= 2;
            b %= 2;
            c %= 2;
            x %= 2;
            y %= 2;
            z %= 2;
            int sum = a+b+c+x+y+z;
            if (dp[sum] >= 0)
                max = Math.max(max, right-dp[sum]);
            else
                dp[sum] = right;
            right++;

        }
        return max;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(new Main().helperString(s));
        }
    }
}
