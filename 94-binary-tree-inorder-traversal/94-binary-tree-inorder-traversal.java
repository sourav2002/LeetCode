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
    
    
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList();
        TreeNode cur = root;
        
        while(cur != null){
            
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    // create threat between last node and root node
                    prev.right = cur;
                    // after creating connection, traverse left of root
                    cur = cur.left;
                }else{
                    // time to break the thraed
                    prev.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
    
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        Stack<TreeNode> st = new Stack();
        
        TreeNode node =  root;
        while( node != null || !st.isEmpty()){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                node = st.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
    */
}