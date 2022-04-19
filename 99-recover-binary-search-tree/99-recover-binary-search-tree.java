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


// morris method for O(1) space complexity
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        TreeNode prev = null;
        TreeNode first = null, second = null;
        
        while(root!= null){
            if(root.left == null){
                // print root
                if(prev != null && prev.val > root.val){
                    if(first == null){
                        first = prev;
                    }
                    second = root;
                }
                prev = root;
                
                root = root.right;
            }else{
                
                TreeNode temp = root.left;
                
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                
                if(temp.right == null){
                    // create thread
                    temp.right = root;
                    root = root.left;
                }
                else{
                    // break thread
                    temp.right = null;
                    
                    //print root
                    if(prev != null && prev.val > root.val){
                        if(first == null){
                            first = prev;
                        }
                        second = root;
                    }
                    prev = root;
                    root = root.right;
                }
            }
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}