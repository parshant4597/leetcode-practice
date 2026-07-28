 class Solution {
    long[][][] dp;
    String n; 
    public long solve(int indx, int tight, int count1) {
        if (indx == n.length()) {
            return count1;
        } 
        if (dp[indx][tight][count1] != -1) {
            return dp[indx][tight][count1];
        }

        int ub = (tight == 1) ? (n.charAt(indx) - '0') : 9;
        long ans = 0;

        for (int i = 0; i <= ub; i++) {
            ans += solve(
                indx + 1,
                (tight == 1 && i == ub) ? 1 : 0,  
                count1 + (i == 1 ? 1 : 0)
            );
        }

        return dp[indx][tight][count1] = ans;
    }

    public int countDigitOne(int nn) {
        n = String.valueOf(nn); 
        dp = new long[11][2][12];
        for (long[][] layer : dp) {
            for (long[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return (int) solve(0, 1, 0);
    }
}