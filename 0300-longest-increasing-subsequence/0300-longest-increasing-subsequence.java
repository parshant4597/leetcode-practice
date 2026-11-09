// class Solution {
//     int[] nums ;  
//     public int solve(int indx , int prev ,  int[][] dp ,int[] nums){
//         if(indx == nums.length){
//             return 0 ; 
//         }
//         if(dp[indx][prev+1] != -1)return dp[indx][prev+1];
//         int take = 0 ; 
//         if(prev != -1 && nums[indx] > nums[prev]){
//             take = 1+ solve(indx+1 , indx , dp , nums);
//         }
//         if(prev == -1){
//             take = 1 + solve(indx +1  ,indx  ,dp , nums);
//         }
//         int notake = solve(indx+1 , prev , dp , nums);
//         return dp[indx][prev+1] = Math.max(take , notake);
//     } 

//     public int lengthOfLIS(int[] num) {
//         int n = num.length ; 
//         nums = num ; 
//         int[][] dp = new int[n+1][n+2];
//         // for(int i = 0 ;i < n+1 ; i++){
//         //     Arrays.fill(dp[i]  , -1);
//         // } 
//         for(int i = n-1 ; i >= 0 ; i--){
//             for(int prev = n-1 ; prev >= -1 ;prev--){
//                 int take = 0 ; 
//                 if(prev == -1 ){
//                     take = 1 + dp[i+1][i+1];
//                 }
//                 if(prev != -1 && nums[i] > nums[prev]){
//                     take = 1 + dp[i+1][i+1];
//                 }
//                 int notake = dp[i+1][prev+1];
//                 dp[i][prev+1] = Math.max(take , notake);
//             }
//         }
//         return dp[0][0];
//     }
// }
// import java.util.Arrays;

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int n = nums.length;
//         // dp[i] stores the LIS starting at index i
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
        
//         int maxLIS = 0;
//         // Try starting the increasing subsequence from every possible index
//         for (int i = 0; i < n; i++) {
//             maxLIS = Math.max(maxLIS, solve(i, nums, dp));
//         }
        
//         return maxLIS;
//     }
    
//     private int solve(int i, int[] nums, int[] dp) {
//         // If already calculated, return the cached result
//         if (dp[i] != -1) {
//             return dp[i];
//         }
        
//         // Base case: Any single element itself is a valid subsequence of length 1
//         int maxLen = 1;
        
//         // Look ahead for any valid next elements that are strictly greater
//         for (int next = i + 1; next < nums.length; next++) {
//             if (nums[next] > nums[i]) {
//                 maxLen = Math.max(maxLen, 1 + solve(next, nums, dp));
//             }
//         }
        
//         // Memoize and return the result for index i
//         return dp[i] = maxLen;
//     }
// }
class Solution {
    int n ; 
    int[][] dp ; 
    public int solve(int[] nums , int i , int prev ){
        if(i == n){
            return 0 ; 
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        int take = 0 ;
        if(prev == -1){
            return dp[i][prev+1] = Math.max(1 + solve(nums , i+1 , i)  , solve(nums , i+1 , prev));
        }
        if(nums[prev] < nums[i]){
            take = 1 + solve(nums , i+1 , i);
        }
        int notake = solve(nums , i+1 , prev);
        return dp[i][prev+1] = Math.max(notake , take);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length ; 
        dp = new int[n+1][n+1];
        for(int i = 0 ;i < n+1  ; i++){
            Arrays.fill(dp[i] ,-1);
        }
        int ans = solve(nums , 0 , -1);
        return ans ; 
   
    }
}

