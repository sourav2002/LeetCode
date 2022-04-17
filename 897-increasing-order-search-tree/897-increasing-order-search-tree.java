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
// use only auxilary stack space
class Solution {

    TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        
        TreeNode res = new TreeNode(-1);
        cur = res;
        inorder(root);
        return res.right;
    }
    
    public void inorder(TreeNode node){
        if(node == null) return;
        
        inorder(node.left);
        // break the left link and add current node at the right of res (cur TreeNode pointing to res)
        node.left = null;
        cur.right = node;
        cur = node;
        
        inorder(node.right);
    }
}
// using extra space O(n)
// time complexity also O(n)
/*
class Solution {
    
    List<TreeNode> list = new ArrayList();
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        
        inorder(root);
        for(int i=0; i< list.size()-1; i++){
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;
        
        return list.get(0);
    }
    
    public void inorder(TreeNode node){
        if(node == null) return;
        
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
}
*/
