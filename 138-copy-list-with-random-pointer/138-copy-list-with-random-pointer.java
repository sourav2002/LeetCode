/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node itr = head;
        Node front = head;
        
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        
        while(itr != null){
            front = itr.next;
            Node copy = new Node(itr.val);
            itr.next = copy;
            copy.next = front;
            itr = front;
        }
        
        
        itr = head;
        // Second round : link random pointer
        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr =itr.next.next;
        }
        
        
        // Third round: restore the original list, and extract the copy list.
          itr = head;
          Node pseudoHead = new Node(0);
          Node copy = pseudoHead;
        
        while(itr != null){
            front = itr.next.next;
            copy.next = itr.next;
            itr.next = front;
            copy = copy.next;
            itr = front;
        }
        
        return pseudoHead.next;
    }
}