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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(100);
        ListNode end = current.next;
        current = head;
        while(current != null){
            System.out.print(current.val+"->");
            current = current.next;
        }
        current = head;
        
        ListNode ans = reverse(current, end);
        return ans;
    }
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode current = start;
        ListNode prev = null;
        ListNode nextNode = null;
        while(current != end){
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}