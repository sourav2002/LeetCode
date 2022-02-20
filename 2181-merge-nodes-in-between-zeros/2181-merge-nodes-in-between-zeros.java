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
    public ListNode mergeNodes(ListNode head) {
     //BASE CASE -> if we have a single zero, simply return null
    if(head.next == null) return head.next;
    
    //fetch sum from current 0 to next 0
    ListNode ptr= head.next;
    int sum=0;
    while(ptr.val != 0){
        sum += ptr.val;
        ptr=ptr.next;
    }  
    
    //assign sum on the first node between nodes having value 0.
    head.next.val= sum;
    
    //call and get the answer and connect the answer to next of head->next
    head.next.next= mergeNodes(ptr);
    
    //return head->next..=> new head
    return head.next;
    }
}