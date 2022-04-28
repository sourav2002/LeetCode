/*
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        int l = 0;
        ListNode cur = head;
        while (cur != null) {
            l++;
            cur = cur.next;
        }
        if (k > l) {
            return head;
        }
        cur = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
*/

class Solution{
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pointer = dummy;
        while(pointer != null){
            // check if remaining nodes are greater or equal to k or not
            ListNode check = pointer;
            for(int i=0; i<k && check != null; i++){
                check = check.next;
            }
            
            if(check == null) break;
            
            // else we know that we have k nodes. we will start from the first node
            ListNode curr = pointer.next;
            ListNode prev = null, nxt = null;
            for(int i=0; i<k; i++){
                nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            
            // after reversing
            // connect the current tail(or old head) with curr node. because curr is pointing to k+1th node(or we can say head of next window)
            
            ListNode tail = pointer.next; // pointer.next was starting/beginning node 
            tail.next = curr; // connected successfully 
            pointer.next = prev; // it is connecting last tail with next head
            pointer = tail;
            // update pointer 
// After one iteration, pointer was at 1 and prev is at 4(new head of 2nd window).
// so 1 should point to 4 to create 2->1->4->3
// That's why we are using this line pointer.next = prev
        }
        return dummy.next;
    }
}