/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       return cycle(head);
    }
    
    ListNode cycle(ListNode head){
        ListNode s = head, f = head;
        
        while(f != null && f.next != null){
            f =f.next.next;
            s = s.next;
            
            if(f == s){
                s = head;
                while(s != f){
                    s =s.next;
                    f =f.next;
                }
                return f;
            }
        }
        return null;
    }
}