package 最长连续序列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                parent.put(nums[i], nums[i]);
            }
            count = nums.length;
        }

        public Integer find(int p) {
            if (!parent.containsKey(p))
                return null;
            // 递归向上找领队
            if (p != parent.get(p))
                parent.put(p, find(parent.get(p)));
            return parent.get(p);
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public void union(int p, int q) {
            Integer pid = find(p);
            Integer qid = find(q);
            if (pid == qid)
                return;
            if (pid == null || qid == null)
                return;
            parent.put(pid, qid);
            count--;
        }

        public int count() {
            return count;
        }
    }
    public int longestConsecutive(int[] nums) {
        // HashSet<Integer> set = new HashSet<Integer>();
        // int res = 0;
        // for(int num:nums){
        //     set.add(num);
        // }
        // for(int num:set){
        //     if(!set.contains(num-1)){//开始
        //         int length=1;
        //         while(set.contains(num+1)){
        //             num++;
        //             length++;
        //         }
        //         res = Math.max(length, res);
        //     }
        // }
        // return res;
        if (nums.length == 0) return 0;
        // 首次遍历，与邻居结盟
        UnionFind uf = new UnionFind(nums);
        for (int v : nums)
            uf.union(v, v + 1); // uf.union() 结盟

        // 二次遍历，记录领队距离
        int max = 1;
        for (int v : nums)
            max = Math.max(max, uf.find(v) - v + 1); // uf.find() 查找领队
        return max;
    }

}
