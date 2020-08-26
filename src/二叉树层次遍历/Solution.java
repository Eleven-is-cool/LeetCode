package 二叉树层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    public TreeNode(int val){
        this.val = val;
    }
}
/*
    非递归
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int level = 0;
        q.add(root);
        while (!q.isEmpty()){
            res.add(new ArrayList<>());
            int len = q.size();

            for(int i=0;i<len;i++){
                TreeNode r = q.remove();
                res.get(level).add(r.val);
                if(r.left != null)
                    q.add(r.left);
                if(r.right != null)
                    q.add(r.right);
            }
            level++;
        }
        return res;
    }
}
/*
    递归
 */
//public class Solution {
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> levelOrder(TreeNode root){
//        if(root == null)
//            return res;
//        helper(root, 0);
//        return res;
//    }
//    public void helper(TreeNode root, int level){
//        if(level == res.size())
//            res.add(new ArrayList<>());
//        res.get(level).add(root.val);
//        if(root.left != null)
//            helper(root.left, level+1);
//        if(root.right != null)
//            helper(root.right, level+1);
//    }
//}