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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> row;
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return ans;
        q.add(root);
        
        while(!q.isEmpty()){
            row = new ArrayList();
            int n = q.size();
            
            for(int i=0; i<n; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                row.add(q.poll().val);
            }
            ans.add(row);
        }
        return ans;
    }
}