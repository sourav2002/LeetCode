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
    // int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return solve(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    public TreeNode solve(int[] arr, int bound, int[] i){
        if( i[0] == arr.length || arr[i[0]] > bound){
            return null;
        }
        
        TreeNode root = new TreeNode(arr[i[0]]);
        root.left = solve(arr, arr[i[0]++], i);
        root.right = solve(arr, bound, i);
        return root;
    }
}