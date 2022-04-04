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
        ListNode temp = new ListNode();
        temp = head;
        int len = 0;
        ListNode first = null;
        int st = 1;
        while (temp != null) {
            if (st == k) {
                first = temp;
            }
            temp = temp.next;
            len++;
            st++;
        }
        int last = len - k + 1;
        st = 1;
        temp = head;
        ListNode second = null;
        while (temp != null) {
            if (st == last) {
                second = temp;
            }
            temp = temp.next;
            st++;
        }
        ListNode t = new ListNode();
        t.val = first.val;
        first.val = second.val;
        second.val = t.val;
        return head;
    }
}
