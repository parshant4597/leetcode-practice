class Solution {
    private boolean solve(int mid, int[] nums, int[][] queries) {
        int n = nums.length;
        long[] diff = new long[n + 1];
        for (int i = 0; i < mid; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diff[l] += val;
            diff[r + 1] -= val;
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

    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (solve(mid, nums, queries)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left > queries.length ? -1 : left;

    }
}