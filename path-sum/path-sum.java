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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    
    public boolean dfs(TreeNode root,int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
        
        return dfs(root.left, sum -root.val ) | dfs(root.right, sum - root.val);
        
    }
}