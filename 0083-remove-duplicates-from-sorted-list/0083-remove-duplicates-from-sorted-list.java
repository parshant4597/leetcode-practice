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
        if(head == null){
            return head ; 
        }
        ListNode temp = head ; 
        if(temp.next == null){
            return temp ; 
        }
        ListNode next = temp.next ; 
        while(temp != null && next != null){
            //  2 2 2  3 3 

            if(temp.val == next.val){
                next = next.next ;  
            }else{
                temp.next = next ; 
                temp = temp.next ; 
            }
        }
        temp.next = null;
         
        return head ; 
        
    }
}