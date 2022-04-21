class Solution {

    public int countNodes(TreeNode node) {
        if (node == null) return 0;

        int left = getLeftHeight(node);
        int right = getRightHeight(node);

        // if left and right are equal, it means the tree is complete
        if (left == right) return ((2 << (left)) - 1);
        //else recursively calculate the number of noded in left and right
        else return countNodes(node.left) + countNodes(node.right) + 1; // +1 for root
    }

    public int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    public int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        } 
        return count;
    }
}
