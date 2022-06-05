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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        
        return list;
    }
}
*/

class Solution{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        TreeNode node = root;
        
        while(node != null){
            if(node.left == null){  
                list.add(node.val);
                node = node.right;
            }else{
                list.add(node.val);
                TreeNode prev = node.left;
                while(prev.right != null && prev.right != node){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = node;
                    node = node.left;
                }else{
                    prev.right = null;
                    node = node.right;
                    list.remove(list.size()-1);
                }
            }
        }
        return list;
    }
}