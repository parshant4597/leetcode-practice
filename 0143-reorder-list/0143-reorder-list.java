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
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        int count = -1;
        Stack<Integer> st   = new Stack<>();
        while(right != null){
            count++;
            st.push(right.val);
            right = right.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode newhead = ans;
        while(!st.isEmpty()){
            ans.next = left ;
            left = left.next;
            ans = ans.next;
            ans.next  = new ListNode(st.peek());
            st.pop();
            ans = ans.next;
        }
        ListNode temp = newhead.next;
        while(count--> 0){
            temp = temp.next;
        }
        temp.next = null;
      

    }
}