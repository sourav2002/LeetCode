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
        ListNode prev = null;
        ListNode nextn = null;
        while(current != null){
            nextn = current.next;
            current.next = prev;
            prev = current;
            current = nextn;
        }
        return prev;
    }
}