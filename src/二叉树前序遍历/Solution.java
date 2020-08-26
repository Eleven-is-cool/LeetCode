package 二叉树前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Solution {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res  = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                res.add(root.val);
                s.push(root);
                root = root.left;
            }
            TreeNode pop = s.pop();
            root = pop.right;
        }
        return res;

    }
}
