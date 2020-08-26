package Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            Map<Integer, Integer> mapRelation = new HashMap<>();//确认认识
            Map<Integer, Integer> mapUnRelation = new HashMap<>();//可能认识
            mapRelation.put(1, 1);
            for(int i = 0; i < M; i++){
                int one = sc.nextInt();
                int two = sc.nextInt();
                int three = sc.nextInt();
                //当有关系时
                if(three == 1){
                    if(mapRelation.containsKey(one) && !mapRelation.containsKey(two)){
                        mapRelation.put(two,two);
                        if(mapUnRelation.containsKey(two)){
                            int tmp = mapUnRelation.remove(two);
                            mapUnRelation.remove(tmp);
                            mapRelation.put(tmp, tmp);
                        }
                    }else if(mapRelation.containsKey(two) && !mapRelation.containsKey(one))  {
                        mapRelation.put(one,one);
                        if(mapUnRelation.containsKey(one)){
                            int tmp = mapUnRelation.remove(one);
                            mapUnRelation.remove(tmp);
                            mapRelation.put(tmp, tmp);
                        }
                    }else if(!mapRelation.containsKey(one) && !mapRelation.containsKey(two)) {
                        if(!mapUnRelation.containsKey(one)) mapUnRelation.put(one, two);
                        if(!mapUnRelation.containsKey(two)) mapUnRelation.put(two, one);
                    }
                }

            }

            System.out.println(mapRelation.size() - 1);
        }
    }
}
//class Solution {
//    public boolean judgePoint24(int[] nums) {
//        ArrayList<Double> A = new ArrayList<>();
//        for (int v: nums) A.add((double) v);
//        return solve(A);
//    }
//
//    private boolean solve(ArrayList<Double> nums) {
//        // 没有可计算的，证明无解
//        if (nums.size() == 0) return false;
//        // le-6是浮点计算的精度误差，这里判断误差小于1e-6，这样就是正确结果
//        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;
//
//
//        for (int i = 0; i < nums.size(); i++) {
//            for (int j = 0; j < nums.size(); j++) {
//                if (i != j) {
//                    // 找到当前排列下的其他两个元素
//                    ArrayList<Double> nums2 = new ArrayList<>();
//                    for (int k = 0; k < nums.size(); k++) {
//                        if (k != i && k != j) {
//                            nums2.add(nums.get(k));
//                        }
//                    }
//
//                    // k的四种计算情况
//                    for (int k = 0; k < 4; k++) {
//                        // 性能优化，当k<2时，对于+ or *不考虑顺序，
//                        // 所以k<2 时，j > i与i > j的结果相同，所以有部分不用考虑
//                        if (k < 2 && j > i) continue;
//                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
//                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
//                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
//                        // 避免除数为0
//                        if (k == 3) {
//                            if (nums.get(j) != 0) {
//                                nums2.add(nums.get(i) / nums.get(j));
//                            } else {
//                                continue;
//                            }
//                        }
//                        // 在这次计算后，判断剩下的元素是否符合要求
//                        // 每次缩小计算范围
//                        if (solve(nums2)) return true;
//                        // 移除最后一个计算结果，因为最后的记过不满足要求
//                        // 就是一种回溯方法，将前面添加的结果删除
//                        nums2.remove(nums2.size() - 1);
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
