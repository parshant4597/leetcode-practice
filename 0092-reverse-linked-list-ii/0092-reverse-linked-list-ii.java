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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1 ; 
        ListNode temp = head;
        ListNode prev = new ListNode(-1); 
        while(temp.next != null && count != left ){//   2 3 
            prev = temp  ; 
            temp = temp.next ; // 2
            count++; // 2
        }
        ListNode temp2 = temp ; 
        Stack<Integer> st = new Stack<>();
        int ans  = right - left + 1 ; 
        while(ans != 0 ){
            st.push(temp2.val);
            ans--;
            temp2 = temp2.next ; 
        } 
        temp = prev ; 
        ListNode headi = prev ; 
        while(!st.isEmpty()){
            temp.next = new ListNode(st.pop());
            temp = temp.next ; 
        }
        temp.next = temp2 ; 
        if(left == 1){
            return headi.next ; 
        }
        return head ; 
        
        
    }
}