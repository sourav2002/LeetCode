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
/*
class Solution{
    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> st = new Stack();
        
        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}

*/
class Solution {
    
    int result = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int K) {
        int k[] = {K};
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int[] k) {
        if(root == null) return;
        traverse(root.left, k);
        if(--k[0] == 0 ) result = root.val;
        traverse(root.right, k);       
    }
}
