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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] longest = new int[1];
        longest[0] = -99;
        solve(root, longest);
        return longest[0];
    }
    
    public int solve(TreeNode node , int[] longest){
        
        if(node == null) return 0;
        
        int left = solve(node.left, longest);
        int right = solve(node.right, longest);
        
        longest[0] = Math.max(longest[0] , left+right);
        return Math.max(left, right)+1;
    }
}