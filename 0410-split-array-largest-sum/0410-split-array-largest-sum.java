class Solution {
    int[][] dp;

    public int solve(int indx, int[] prefix, int k, int n) {
        // Base Case 1: If we reached the end of the array
        if (indx == n) {
            return (k == 0) ? 0 : (int) 1e9;
        }
        // Base Case 2: If we run out of partitions but elements are still left
        if (k == 0) {
            return (int) 1e9;
        }
        
        // Return cached result if already calculated
        if (dp[indx][k] != -1) {
            return dp[indx][k];
        }

        int take = (int) 1e9;

        // Try splitting at every possible next index 'i'
        for (int i = indx; i < n; i++) {
            // Sum of current subarray from 'indx' to 'i'
            int currentSubarraySum = prefix[i + 1] - prefix[indx];
            
            // We want the MAXIMUM configuration between the current subarray 
            // and the remaining partitions
            int maxForThisSplit = Math.max(currentSubarraySum, solve(i + 1, prefix, k - 1, n));
            
            // Minimize that maximum over all choices
            take = Math.min(take, maxForThisSplit);
        }

        return dp[indx][k] = take;
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
}