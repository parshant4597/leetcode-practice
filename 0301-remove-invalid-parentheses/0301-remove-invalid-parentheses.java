class Solution {
    List<String> ansList ;  
    String s ; 
    //sb.deleteCharAt(sb.length() - 1).
    public void solve(int indx , StringBuilder sb , int open , int close , Stack<Character> st){
        if(indx == s.length()){
            if(st.isEmpty() && open == 0 && close == 0 && !ansList.contains(sb.toString())){ 
                ansList.add(sb.toString());
                 return  ;
            }else{
                return ; 
            }
        }
        char ch = s.charAt(indx);
        if(ch == '('){
            // take  ;
            st.push(ch);
            sb.append(ch);
            solve(indx + 1 , sb , open , close , st);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
            // dontake ,
            if(open > 0 ){
                 open--;
            solve(indx + 1 , sb , open , close  , st);
            open++;
            }
            
        }else if(ch == ')'){
            boolean flag = false ;
            char top = 'A';
            if(!st.isEmpty() && st.peek() == '('){
                flag = true ; 
                  top =   st.pop();
                }else{
                    st.push(ch);
                }
            sb.append(ch);
            solve(indx +1  , sb , open , close , st);
            sb.deleteCharAt(sb.length() - 1);
            if(flag){
                st.push(top);
            }else{
                st.pop();
            }
            if(close > 0){
                close--;
            solve(indx + 1 , sb , open , close  , st);
            close++;
            }
             
        }else{
            sb.append(ch);
            solve(indx + 1, sb, open, close, st);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> removeInvalidParentheses(String s) {
        this.s = s ; 
        // minimum stack di help nam ..
        // open - 2 
        // close - 2 
        // rec with stack with minimum ki
        // rec de end te stack shi rhi removal de nal v pher ta oh answer add kardo //
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else st.push(ch);
            }
        }
        int   open = 0 ; 
        int   close = 0 ; 
        while(!st.isEmpty()){
            char ch = st.pop();
            if(ch == ')'){
                close++;
            }else{
                open++;
            }
        }
        this.ansList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0 ,  sb, open , close   , new Stack<>());
        return ansList ;         
    }
}