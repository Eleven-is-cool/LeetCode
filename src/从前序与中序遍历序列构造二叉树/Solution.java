package 从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, map, 0, inorder.length);
    }
    public TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                    Map<Integer, Integer> inorderMap, int i_start, int i_end){
        if (p_start == p_end)
            return null;
        TreeNode curRoot = new TreeNode(preorder[p_start]);
        int i_index = inorderMap.get(curRoot);
        // 找到了当前前序数组中的值的序号，则在中序数组中该序号前面的都是左子树，后面的都是右子树
        int temp =  i_index - i_start;
        curRoot.left = buildTreeHelper(preorder, p_start+1, p_start+temp+1, inorderMap,  i_start, i_index);
        curRoot.right = buildTreeHelper(preorder, p_start+temp+1, p_end, inorderMap, i_index+1, i_end);
        return curRoot;

    }
}
