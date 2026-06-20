class Solution {
    
    private int[] expand(String s, int left, int right) {
         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left +1, right} ;
    }
   
    public String longestPalindrome(String s) {
        int count = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) { 
            int[] ans1 = expand(s, i, i); 
            int[] ans2 =  expand(s, i, i + 1);
            if(ans1[1] - ans1[0] > ans2[1] - ans2[0]){
                if(res.length() < ans1[1] - ans1[0]){
                    res = s.substring(ans1[0] , ans1[1]);
                }
            }else{
                if(res.length() < ans2[1] - ans2[0]){
                    res = s.substring(ans2[0] , ans2[1]);
                }

            }
            
        }
        return res;
   
    }
}
// class Solution {
//     public int countSubstrings(String s) {
//         int count = 0;

//         for (int i = 0; i < s.length(); i++) {
//             // Case 1: Odd length palindromes (center is at a character)
//             count += expand(s, i, i);
//             // Case 2: Even length palindromes (center is between two characters)
//             count += expand(s, i, i + 1);
//         }
//         return count;
//     }
 
// }
  // String res = "";
    // int maxlen = 0 ; 
    // public boolean ispalid(String s){
    //     int left =  0 ; 
    //     int right = s.length() - 1; 
    //     while(left <= right){
    //         if(s.charAt(left) != s.charAt(right)){
    //             return false ; 
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true ; 
    // }
    // int[] dp ; 
    // public void solve(String s , int indx , String str){
  
    //     if(ispalid(str)){
    //             if(str.length() > maxlen){
    //                 res = str;
    //                 maxlen = res.length();
    //             }  
    //     } 
    //     if(indx == s.length())return ; 
       
    //     solve(s , indx+1 , str + s.charAt(indx));  
    //     solve(s , indx+1 , "");
 
    // }
      //    for(int i = 0 ; i < s.length() ; i++){
    //     String res = "";
    //     for(int j = i ; j < s.length() ; j++){
    //         res += s.charAt(j);
    //         if(ispalid(res)){
    //             if(res.length() > maxres.length()){
    //                 maxres = res ; 
    //             }
    //         }
    //     }
    //    }
    //    return maxres ; 
