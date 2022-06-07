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
public class Solution {
    // int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) {
        int[] arr = new int[2];
        findBottomLeftValue(root, 1, arr); // (0th = ans ans 1st = h)
        return arr[0];
    }
    public void findBottomLeftValue(TreeNode root, int depth, int[] arr) {
        if (arr[1] < depth) {
            arr[0]=root.val;
            arr[1] =depth;
        }
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, arr);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, arr);
    }
}