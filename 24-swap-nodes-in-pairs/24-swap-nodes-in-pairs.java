/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode current = head;
        
        while(current != null && current.next != null){
            prev.next = current.next;
            current.next = prev.next.next;
            prev.next.next = current;
            
            // update current and prev;
            current = current.next;
            prev = prev.next.next;
            
            
        }
        return dummy.next;
        
        
    }
}