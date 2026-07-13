import java.util.Arrays;

class Solution {
    // Helper method to check if column 'a' and column 'b' can be adjacent
    private boolean isCompatible(int[][] grid, int a, int b, int limit) {
        int rows = grid.length;
        for (int r = 0; r < rows; r++) {
            if (Math.abs(grid[r][b] - grid[r][a]) > limit) {
                return false;
            }
        }
        return true;
    }

    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[j] stores the max consistent columns ending at column j
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every single column by itself is a valid sequence of length 1
        
        int maxColumns = 1;
        
        // Classic LIS approach
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (isCompatible(grid, i, j, limit)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxColumns = Math.max(maxColumns, dp[j]);
        }
        
        return maxColumns;
    }
}