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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode fast, slow = new ListNode(0);
        fast = slow;
        slow.next = head;
        while(head!=null && head.next!=null){
        	if(head.val==head.next.val){
                while(head.next!= null && head.val==head.next.val){
                    head = head.next;
                }
                head = head.next;
                fast.next = head;
            }else{
                head = head.next; 
                fast = fast.next;
            }          
        }
        return slow.next;
    }
}