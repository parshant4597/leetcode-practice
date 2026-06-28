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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<Integer> st = new Stack<>();
        ListNode newtemp = new ListNode(-1);
        ListNode temp = head ; 
        ListNode newhead  = newtemp ; 
        int count = 0; 
        while(temp != null){
             temp = temp.next ; 
             count++;
        }
        // corr
        
        temp = head ; 
         
        int num = count%k; 
        int diff = count - num ; 
        while(diff-- > 0 && temp != null){
            st.push(temp.val);
            temp = temp.next ; 
            if(st.size() == k){
                while(!st.isEmpty()){
                    int top = st.pop();
                    newhead.next = new ListNode(top);
                    newhead = newhead.next ; 
                }
            }
        }
        while(num-->0 && temp != null ){
            newhead.next = temp ; 
            temp = temp.next ; 
            newhead = newhead.next ; 
        }
        return newtemp.next ;

        
    }
}
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null || k == 1) return head;
         
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
        
//         ListNode curr = dummy, nex = dummy, pre = dummy;
//         int count = 0;
//         while (curr.next != null) {
//             curr = curr.next;
//             count++;
//         }
//         while (count >= k) {
//             curr = pre.next;
//             nex = curr.next;
//             for (int i = 1; i < k; i++) {
//                 curr.next = nex.next;
//                 nex.next = pre.next;
//                 pre.next = nex;
//                 nex = curr.next;
//             }
//             pre = curr;
//             count -= k;
//         }
        
//         return dummy.next;
//     }
// }