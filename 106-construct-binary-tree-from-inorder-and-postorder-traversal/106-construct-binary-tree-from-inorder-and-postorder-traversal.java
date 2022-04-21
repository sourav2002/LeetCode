class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = build(inorder, postorder, 0, postorder.length-1, postorder.length-1,map);
        return root;
    }
    
    public TreeNode build(int[] inorder, int[]postorder, int s, int e, int pin, Map<Integer, Integer> map){
        
        if(s > e ) return null;
        
        int inRoot = map.get(postorder[pin]);
        
        TreeNode root = new TreeNode(postorder[pin]);
        
        root.left = build(inorder, postorder, s, inRoot-1, pin-1-e+inRoot , map);
        root.right = build(inorder, postorder, inRoot+1, e, pin-1, map);
        
        return root;
        
        
    }
}
