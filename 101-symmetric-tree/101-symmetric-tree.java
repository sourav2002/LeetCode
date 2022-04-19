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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return check(root.left, root.right);
    }
    public boolean check(TreeNode a, TreeNode b){
        if(a == null || b == null) return a == b;
        
        if(a.val != b.val) return false;
        return check(a.left, b.right) && check(a.right, b.left);
    }
}