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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap();
        for(int i=0; i< inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = build(preorder, inorder, 0, inorder.length-1, inMap, 0);
        return root;
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int s, int e, Map<Integer, Integer> inMap, int preInd){
        
        if(s > e){ //base case
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preInd]);
        
        int inRoot = inMap.get(preorder[preInd]);
        
        root.left = build(preorder,inorder, s,  inRoot-1, inMap, preInd+1);
        
        root.right = build(preorder,inorder, inRoot+1, e, inMap, (preInd+1)+(inRoot-s) );
        
        return root;
        
    }
}