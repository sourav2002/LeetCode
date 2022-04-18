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
    public int maxPathSum(TreeNode root) {
        
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }
    
    public int maxPathDown(TreeNode root, int[] maxValue){
        if(root == null) return 0;
        
        int maxsumleft = maxPathDown(root.left, maxValue);
        if(maxsumleft < 0) maxsumleft = 0;
        int maxsumright = maxPathDown(root.right, maxValue);
        if(maxsumright < 0) maxsumright = 0;
        
        maxValue[0] = Math.max(maxValue[0], (maxsumleft+ maxsumright+ root.val));
        return Math.max(maxsumleft, maxsumright) + root.val;
    }
}