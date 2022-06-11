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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root == null) return ans;
        q.offer(root);
        List<Integer> list;
        int c = -1;
        while(!q.isEmpty()){
            int n = q.size();
            list = new ArrayList();
            for(int i =0; i< n; i++){
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                list.add(cur.val);
            }
            c++;
            if(c % 2 == 0){
                ans.add(list);
            }else{
                Collections.reverse(list);
                ans.add(list);
            }
        }
        return ans;
    }
}

/*
Same code as Binary Tree Level Order Traversal.
just take a variable (in my solution, it is c) to check if current **row is even or odd**
**if it is even** then **insert original** row-list in ans-list
else **insert reverse** of row-list in our ans-list

Because here we are using **reverse method** which **take O(n) time**, we are calling reverse method only half of height of binary tree times
**height of binary tree / 2**, because we are calling this method alternatively.
*/