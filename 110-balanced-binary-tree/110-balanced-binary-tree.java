/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        
        height(root, flag);
        return flag[0];
    }
    
    public int height(TreeNode root, boolean[] flag){
        if(root == null) return 0;
        
        int left = height(root.left, flag);
        int right = height(root.right, flag);
        
        if(Math.abs(right - left) > 1) flag[0] = false;
        return Math.max(left, right)+1;
    }
}