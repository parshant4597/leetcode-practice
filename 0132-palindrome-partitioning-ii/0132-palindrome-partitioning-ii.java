// class Solution {
//     int[] dp ;
//     public boolean ispalid(String s  , int i , int j){
//         while(i <= j){
//             if(s.charAt(i) == s.charAt(j)){
//                 i++;
//                 j--;
//             }else{
//                 return false; 
//             }
//         }
//         return true ; 
//     }
//     public int solve(String s , int indx ){
//         if(indx == s.length()){
//             return 0 ; 
//         }
//         if(dp[indx] != -1){
//             return dp[indx];
//         }
//         int take = (int)1e9 ; 
//             for(int i = indx; i < s.length() ; i++){
//                  if(ispalid(s , indx , i )){
//                     take = Math.min(1+ solve(s  , i+1 ) , take);
//                  }
//             }
        
//         return dp[indx] = take  ; 
//     }
//     public int minCut(String s) {
//         dp = new int[s.length()+1];
//         Arrays.fill(dp , -1);
//        return  solve(s  ,  0 ) - 1;
//     }
// }
import java.util.Arrays;

class Solution {
    private int[] dp;
    private boolean[][] isPalid;

    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        dp = new int[n];
        Arrays.fill(dp, -1);
        
        // Step 1: Precompute all palindromes (O(n^2))
        isPalid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalid[i][i] = true; // Single characters are palindromes
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2 || isPalid[i + 1][j - 1]) {
                        isPalid[i][j] = true;
                    }
                }
            }
        }

        // Step 2: Find minimum jumps from index 0
        int minJumps = solve(s, 0);
        
        // Cuts = Jumps - 1
        return minJumps - 1;
    }

    // Returns the minimum jumps needed to process the string from 'i' to the end
    private int solve(String s, int i) {
        // Base case: Frog has jumped past the end of the string
        if (i == s.length()) {
            return 0;
        }

        // Return memoized result if already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        int minJumps = (int) 1e9;

        // The frog tries to jump to any valid index 'j'
        for (int j = i; j < s.length(); j++) {
            // Frog can only jump if the region s[i...j] is a palindrome
            if (isPalid[i][j]) {
                int jumpsFromHere = 1 + solve(s, j + 1);
                minJumps = Math.min(minJumps, jumpsFromHere);
            }
        }

        return dp[i] = minJumps;
    }
}