/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode temp = head1  ;
        ListNode temp2 = head2 ; 
        while(temp != temp2){
            if(temp.next == null && temp2.next == null){
                return null ; 
            }
            if(temp.next == null){
                temp = head2 ; 
            }else temp = temp.next ;
             
            if(temp2.next == null){
                temp2 = head1 ; 
            }else temp2 = temp2.next ; 
        }
         
        return temp ; 
    }
}