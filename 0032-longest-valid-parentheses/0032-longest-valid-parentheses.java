// class Solution {
//     String s  ; 
   
//     public int longestValidParentheses(String s) {
//         this.s = s  ; 

//         if(s.length() <= 1){
//             return 0  ; 
//         }
//         int ans = 0 ; 
//         int count = 0 ; 
//         for(int i = 0 ; i < s.length() ; i++){
//             if(s.charAt(i) == '('){
//                 count++;
//             }
//         }
//         if(count == s.length())return 0 ; 
//         for(int i =0 ; i < s.length() ; i++){
//             int open = 0 ; 
//             int close = 0 ; 
//             if( ans >= s.length() - i + 1){
//                 break ; 
//             }
//             for(int j = i ; j < s.length() ; j++){
//                 char ch = s.charAt(j);
//                 if(ch == '('){
//                     open++;
//                 }else{
//                     close++;
//                 }
//                 if(open == close){
//                     ans = Math.max(ans ,j - i + 1);
//                 }
                 
//                  if(close > open){
//                     i = j ; 
//                     break ; 
//                  }
//             }
//         }
//          return ans ; 
//     }
// }
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }

        return max_len;        
    }
}