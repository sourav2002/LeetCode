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

    enum State {
        CAMERA,
        MONITORED,
        NOT_MONITORED
    }

    private static class Status {
        int cameras;
        State state;

        Status(int cameras, State state) {
            this.cameras = cameras;
            this.state = state;
        }
    }

    public int minCameraCover(TreeNode root) {
        Status status = getStatus(root);
        if (status.state == State.NOT_MONITORED) {
            status.cameras++;
        }
        return status.cameras;
    }

    private Status getStatus(TreeNode node) {
        if (node == null) return new Status(0, State.MONITORED);

        Status left = getStatus(node.left);
        Status right = getStatus(node.right);

        Status curr = new Status(left.cameras + right.cameras, State.NOT_MONITORED);

        if (left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED) {
            curr.cameras++;
            curr.state = State.CAMERA;
        } else if (left.state == State.CAMERA || right.state == State.CAMERA) {
            curr.state = State.MONITORED;
        }

        return curr;
    }
}
/*
class Solution {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
*/
