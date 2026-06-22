class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
         int n = nums.length; 
        long[] diff = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1]; 
            diff[l] += 1;
            diff[r + 1] -= 1;
        } 
        long currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i];
            if (currentDecrement < nums[i]) {
                return false; 
            }
        }
        return true;
        
    }
}