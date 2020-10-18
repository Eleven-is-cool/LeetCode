package 平衡二叉树;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    public int isBalancedHelper(TreeNode root) {
        if (root == null)
            return 0;

        int left = isBalancedHelper(root.left);
        if (left == -1)
            return -1;

        int right = isBalancedHelper(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left-right) >= 2)
            return -1;
        else
            return Math.max(left, right) +1;
    }


}
