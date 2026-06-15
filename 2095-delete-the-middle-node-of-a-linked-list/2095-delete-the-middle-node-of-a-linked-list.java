// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         ListNode slow = head ;  
//         ListNode fast = head ; 
//         ListNode temp = head ; 
//         if(head.next == null){
//             return null ; 
//         } 
//         // 1 2 3 4 
//         // temp 1 
//         // slow 2 
//         // fast 3 
//         while(fast != null && fast.next != null ){
//             temp = slow ;
//             slow = slow.next ; 
//             if(fast.next.next == null){
//                 fast = null  ;
//             }else fast = fast.next.next ; 
             
//         }
//         slow  = slow.next ; 
//         temp.next = slow ; 
//         return head ; 
        
//     }
// }
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = slow.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}