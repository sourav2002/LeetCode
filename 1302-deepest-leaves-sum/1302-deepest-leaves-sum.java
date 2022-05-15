class Solution {

    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList();
        int sum = 0;
        // int i;
        q.add(root);
        while (!q.isEmpty()) {
            sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return sum;
    }
}
