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

// Given an array of listNdoe type element  arr(new ListNode);
// Time complexity =  n * log(k)
/*
    Using 2 pointer method 
   1 set start point = arr[0] and end = arr[n-1];
   2 now merge lists of start and end point
   3 then increment start and decrement end 
   4 run 2nd and 3rd step while start < end 
   5 run 4th steps while end != 0
   6 in 4th step loop, if we overlapped lists i.e i >= j then update end == j and then run 5th step again by              checking if (end != 0)

    
*/


class Solution {
    
    public static ListNode sMerge(ListNode a, ListNode b){
        ListNode result = null;
        if(a == null) return b;
        else if(b == null) return a;
        
        if(a.val <= b.val){
            result = a;
            result.next = sMerge(a.next, b);
        }else{
            result = b;
            result.next = sMerge(a, b.next);
        }
        return result;
    }
    
    public ListNode mergeKLists(ListNode[] list) {
        if(list.length == 0){
            ListNode newlist = null;
            return newlist;
        }
        int i =0; 
        int last = list.length-1;
        int j =0;
        
        while(last !=0){
            i =0;
            j = last;
            while(i<j){
                list[i] = sMerge(list[i], list[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        return list[0];
    }
}