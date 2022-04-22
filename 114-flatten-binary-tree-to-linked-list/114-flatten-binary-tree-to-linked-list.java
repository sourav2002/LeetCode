/*
// morris traversal (create connection of root's left extreme right node with root's right node)
class Solution {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        if(root == null) return;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode thread = cur.left;
                while (thread.right != null) {
                    thread = thread.right;
                }

                thread.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }
}
*/



// DFS traversal( right -> Left -> root)
class Solution {

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
        
    }
}



/*
// (Linear traversal using stack) 3ms 14% fast 
class Solution {

    public void flatten(TreeNode root) {
        if(root == null)return;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            if(cur.right != null){
                st.push(cur.right);
            }
            if(cur.left != null){
                st.push(cur.left);
            }
            
            if(!st.isEmpty()){
                cur.right = st.peek();
                cur.left = null;
            }
        }
    }
}
*/

