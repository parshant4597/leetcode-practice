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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = new  ListNode(-1);
        ListNode onehead = temp ; 
        ListNode second = new ListNode(-1);
        ListNode newhead = second ; 
        ListNode it = head ; 
        while(it != null){
            if( it.val < x){
                temp.next = it ;
                temp = temp.next ; 
            }else{
                second.next = it ; 
                second = second.next ; 
            }
            it = it.next ; 
            
        }
        second.next = null ;
        temp.next = newhead.next ; 
        return onehead.next ; 
    }
}