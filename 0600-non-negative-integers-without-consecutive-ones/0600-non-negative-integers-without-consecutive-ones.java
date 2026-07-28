class Solution {
    int firstindx = -1;
    int[][][] dp;

    public int solve(String s, int indx, int tight, int prev) {
        if (indx == s.length()) {
            return 1;
        }
        if (dp[indx][tight][prev] != -1) {
            return dp[indx][tight][prev];
        }

        int ans = 0;
        int lb = 0;
        int ub = (tight == 1) ? (s.charAt(indx) - '0') : 1;
        for (int i = lb; i <= ub; i++) {
            if (1 == prev && i == 1)
                continue;
            ans += solve(s, indx + 1, (i == ub && tight == 1) ? 1 : 0, i);
        }
        return dp[indx][tight][prev] = ans;

    }

    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        dp = new int[32][2][2];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
       
        int ans_r = solve(s, 0, 1, 0);
        return ans_r;
    }
}