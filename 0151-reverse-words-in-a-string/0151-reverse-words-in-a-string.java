class Solution {
    public String reverseWords(String s) {
     
        StringBuilder sb = new StringBuilder();
        int left = s.length() - 1 ; 
        int right  = s.length() - 1 ;
        while(right >= 0 && left >= 0){
            while(right >= 0 && s.charAt(right) != ' '){
                right--;
            }
            String sub = s.substring(right+1, left + 1); 
            sb.append(sub);
            sb.append(" ");
            right--;
            left = right ; 
        
        }
       
        // remove st 
        int i = 0 ; 
        while(i < sb.length() && sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
        }
         
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length()-1);
        }
        i = 0 ;
        while(i < sb.length()){
            if(sb.charAt(i) == ' ' && sb.charAt(i+1) == ' '){
                sb.deleteCharAt(i);
            }else{
                i++;
            }
        }
        return sb.toString() ; 
        
    }
}