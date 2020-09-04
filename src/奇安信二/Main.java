package 奇安信二;

import java.util.*;

public class Main {

    public static void main(String[] args) {

            System.out.println(new Main().house(new int[]{8}));


    }
    public int house (int[] person) {
        // write code here
        int res = 1;
        for (int i=1; i<person.length; i++){
            if (person[i] > person[i-1]){
                res += 2;
            }
            if (person[i] < person[i-1]){
                res += 2;
            }
            if (person[i] == person[i-1])
                res += 1;
        }
        return res;
    }

}
