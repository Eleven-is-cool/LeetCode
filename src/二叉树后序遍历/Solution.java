package 二叉树后序遍历;

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
    public List<Integer> backOrderTraversal(TreeNode root){
        List<Integer> res  = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.peek();
            if(cur.right == null || cur.right == last){
                res.add(cur.val);
                s.pop();
                last = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return res;

    }
}