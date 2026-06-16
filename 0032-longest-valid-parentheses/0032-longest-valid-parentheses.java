class Solution {
    String s  ; 
   
    public int longestValidParentheses(String s) {
        this.s = s  ; 

        if(s.length() <= 1){
            return 0  ; 
        }
        int ans = 0 ; 
        int count = 0 ; 
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                count++;
            }
        }
        if(count == s.length())return 0 ; 
        for(int i =0 ; i < s.length() ; i++){
            int open = 0 ; 
            int close = 0 ; 
            if( ans >= s.length() - i + 1){
                break ; 
            }
            for(int j = i ; j < s.length() ; j++){
                char ch = s.charAt(j);
                if(ch == '('){
                    open++;
                }else{
                    close++;
                }
                if(open == close){
                    ans = Math.max(ans ,j - i + 1);
                }
                 
                 if(close > open){
                    i = j ; 
                    break ; 
                 }
            }
        }
         return ans ; 
    }
}