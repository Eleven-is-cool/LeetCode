package 同城二;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
}
public class Main {
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            res.add(new ArrayList<>());
            int len = q.size();
            for (int i = 0; i < len; i++){
                TreeNode cur = q.remove();
                res.get(n).add(cur.val);
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            n++;
        }
        return res;
    }
}
