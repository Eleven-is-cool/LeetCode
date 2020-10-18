package 广联达三;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public int helper(HashMap<Long, Long> map, Long y){
        int res = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            Long hp = entry.getValue();
            if (hp > 0){
                for (Map.Entry<Long, Long> entry2 : map.entrySet()) {
                    if (entry2.getKey() <= entry.getKey() + 2 * y){
                        map.put(entry2.getKey(), entry2.getValue() - hp);
                    }
                }
                res += hp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Long n = sc.nextLong();
            Long y = sc.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i < n; i++){
                map.put(sc.nextLong(), sc.nextLong());
            }
            System.out.println(new Main().helper(map, y));
        }
    }
}
