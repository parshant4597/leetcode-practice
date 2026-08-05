class Solution {
    public boolean solve(int mid , int[] nums , int k ){
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            ans += nums[i];
            if(ans > mid){
                ans -= nums[i];
                k--;
                ans = nums[i];
            }
            if(k == 0 && i < nums.length){
                return false ; 
            }
            
        }
        return true ;

    }
    public int splitArray(int[] nums, int k) {
        int left = 0 ;
        int right = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            left = Math.max(nums[i] , left);
            right += nums[i];
        }
        int ans = 0 ; 
        while(left <= right){
            int mid = (right - left)/2 + left ; 
            if(solve(mid , nums , k)){
                ans = mid ; 
                right = mid - 1 ; 
            }else{
                left =mid +1 ; 
            }
        }
        return ans ; 
        
    }
}
/**
class Solution {
    int[][] dp;

    public int solve(int indx, int[] prefix, int k, int n) {
        if(indx == n){
             if(k != 0 ){
            return (int)1e9 ; 
        }
            return 0 ; 
        }
        if(k == 0 ){
            return (int)1e9 ; 
        }
        if(dp[indx][k] != -1)return dp[indx][k];
        int ans = (int)1e9  ; 
        for(int i = indx  ; i < n ; i++){
            int sum = prefix[i+1] - prefix[indx];
            int anns = solve(i+1 , prefix , k- 1, n) ; 
            ans = Math.min( ans , Math.max(anns , sum));
        }
        return dp[indx][k] = ans ; 
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
         
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
 
        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, prefix, k, n);
    }
} */