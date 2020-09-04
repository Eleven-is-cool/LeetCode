package 二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String sb = new String();
        dfs(root, sb, res);
        return res;

    }

    public void dfs(TreeNode root, String sb, List<String> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(sb + root.val);
            return;
        }
        dfs(root.left, sb + root.val + "->", res);
        dfs(root.right, sb + root.val + "->", res);

    }
}


