package 离店时间;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int A = sc.nextInt();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < N; i++){
                int id = sc.nextInt();
                int in = sc.nextInt();
                int out = sc.nextInt();
                if(in <= A && out >= A) {
                    l.add(id);
//                    System.out.println(id);
                }
            }
            Collections.sort(l);
            if(l.size() == 0)
                System.out.println("null");
            else{
                for(Integer a:l){
                    System.out.println(a);
                }
            }
        }
    }
}
