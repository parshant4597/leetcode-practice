class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode anshead = ans ; 
        ListNode temp = head ;  
        while(temp != null){
            ListNode prev = temp ; 
            int count = 0 ; 
            while(temp != null && temp.val == prev.val){
                count++;
                temp = temp.next ; 
            }
            if(count == 1){
                ans.next = prev ; 
                ans = ans.next ;
            }
        }
        ans.next  = null;
        return anshead.next ; 
         
    }
}