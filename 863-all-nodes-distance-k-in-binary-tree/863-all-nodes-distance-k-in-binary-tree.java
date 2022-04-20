/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
2 steps:
    1) mark parent
    2) move in all direction from current node, (parent, left, right)
        - do not move in already visited direction. For example, from node 5, we go to its left
        let say it 6, so parent of 6 is 5. Do not move toward 5. 
        - For that we will store that node in a data structure to check visited or not.

*/
class Solution {
    
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentmap){
        // bfs
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left != null){
                q.offer(current.left);
                parentmap.put(current.left, current); // set parent of left node
            }
            if(current.right != null){
                q.offer(current.right);
                parentmap.put(current.right, current);
            }
        }    
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parentmap = new HashMap();
        markParent(root, parentmap);
        
        Set<TreeNode> visited = new HashSet(); // search if node exist or not is in O(1) time in set
        Queue<TreeNode> q = new LinkedList();
        q.offer(target); // add target node in queue and move in all directions
        visited.add(target);
        
        int curLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curLevel == k) break;
            curLevel++;
            
            for(int i=0; i<size; i++){
                TreeNode current = q.poll();
                if(current.left != null && !visited.contains(current.left)){
                    q.offer(current.left);
                    visited.add(current.left);
                }
                if(current.right != null && !visited.contains(current.right)){
                    q.offer(current.right);
                    visited.add(current.right);
                }
                if(parentmap.get(current) != null && !visited.contains(parentmap.get(current))){
                    q.offer(parentmap.get(current));
                    visited.add(parentmap.get(current));
                }
            }
        }
        List<Integer> ans = new ArrayList();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}