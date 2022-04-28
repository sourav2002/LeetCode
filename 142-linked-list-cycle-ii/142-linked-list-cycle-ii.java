public class Solution {

    public ListNode detectCycle(ListNode head) {
        return cycle(head);
    }

    ListNode cycle(ListNode head) {
        ListNode s = head, f = head;
        // it is possible that there is no loop so our code should exit from this loop
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            if (f == s) {
                s = head;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return f;
            }
        }
        return null;
    }
}
