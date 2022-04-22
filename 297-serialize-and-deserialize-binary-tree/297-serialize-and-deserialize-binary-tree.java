/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null) {
                sb.append("# ");
            }else {
                sb.append(cur.val+" ");
            }
            if(cur != null){
                q.add(cur.left);
                q.add(cur.right);
            } 
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        for(int i=1; i< arr.length; i++){
            TreeNode cur = q.poll();
            if(!arr[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                cur.left = left;
                q.add(left);
            }
            if(!arr[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                cur.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));