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
    public ListNode reverseList(ListNode head) {
        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head ;  
        // while(temp != null){
        //     st.push(temp.val);
        //     temp = temp.next ; 
        // }
        // ListNode newhead = new ListNode(-1);
        // temp = newhead ; 
        // while(!st.isEmpty()){
        //     temp.next = new ListNode(st.pop());
        //     temp = temp.next ; 
        // }
        // return newhead.next ; 
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save the rest of the list
            curr.next = prev;              // 2. Reverse the current node's pointer
            prev = curr;                   // 3. Move prev forward
            curr = nextTemp;               // 4. Move curr forward
        }
        
        return prev;  
    }
}