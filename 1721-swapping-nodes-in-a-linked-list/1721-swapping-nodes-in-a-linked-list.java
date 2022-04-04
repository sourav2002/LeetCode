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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int count = 1;

        while (curr.next != null) {
            if (count < k) {
                pointer1 = pointer1.next;
            } else {
                pointer2 = pointer2.next;
            }
            curr = curr.next;
            count++;
        }

        int temp = pointer1.val;
        pointer1.val = pointer2.val;
        pointer2.val = temp;

        return head;
    }
}
