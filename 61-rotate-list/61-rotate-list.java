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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode temp = head;
        int len = 1; // l= 1 bcz we will stop temp on last node 
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        
        temp.next = head; // form cycle
        k = k%len; // in case if k is greater then size of list
        int i = len - k; // temp is at last node of list. Move it i times.
        for(int loop = i; loop > 0; loop--){
            temp = temp.next;
        }
        
        ListNode newH = temp.next; // now break the cycle but before breaking store next pointer bcz its gonna be //new head
        temp.next = null;
        return newH;
    }
}