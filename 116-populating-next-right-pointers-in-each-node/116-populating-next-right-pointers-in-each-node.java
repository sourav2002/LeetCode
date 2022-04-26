/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


// use dummy node to connect each row
// space complexity is O(n), not an optimal approach
/*
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node dummy = new Node(-1);
            while(size-->0){
                Node cur = q.poll();
                dummy.next = cur;
                dummy = dummy.next;
                
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return root;
    }
}
*/

class Solution{
    public Node connect(Node root){
        if(root == null) return null;
        
        Node head = root;
        while(head != null){
            Node dummy = new Node(0);
            Node temp = dummy;
            
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next; // (last time, head = dummy.next. So head(2) -> (3) -> null)
            }
            head = dummy.next; // dummy(0) -> (2) -> (3) -> null (temp node had connected them)
        }
        return root;
    }
}