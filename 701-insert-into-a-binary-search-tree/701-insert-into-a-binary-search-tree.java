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
    public TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        TreeNode curr = root;
        
        while(true){
            if(value < curr.val){
                if(curr.left == null){
                    curr.left = new TreeNode(value);
                    return root;
                }
                curr = curr.left;
            }else{
                if(curr.right == null){
                    curr.right = new TreeNode(value);
                    return root;
                }
                curr = curr.right;
            }
        }
    }
}