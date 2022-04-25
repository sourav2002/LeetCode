class bstiterator{
    Stack<TreeNode> st;
    boolean isReverse;
    
    public bstiterator(TreeNode root, boolean reverse){
        isReverse = reverse;
        st = new Stack();
        pushAll(root);
    }
    
    public void pushAll(TreeNode root){
        while(root != null){
            st.push(root);
            if(isReverse == true){
                root = root.right;
            }else{
                root = root.left;
            }
        }
    }
    
    public int next(){
        TreeNode temp = st.pop();
        if(isReverse == false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }
    
    public boolean hasNext(){
        return !st.isEmpty();
    }
    
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        bstiterator l = new bstiterator(root, false);
        bstiterator r = new bstiterator(root, true);
        
        int i = l.next();
        int j = r.next();
        
        while( i < j){
            if(i+j == k) return true;
            if(i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}