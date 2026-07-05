class Solution {
    // String s, t;
    // int[][][] dp;

    // boolean solve(int i, int j, int f) {
    //     int n = s.length(), m = t.length();
    //     if (i == n) return true;
    //     if (j == m) return false;
    //     if (dp[i][j][f] != -1) return dp[i][j][f] == 1;
    //     boolean ans;
    //     if (s.charAt(i) == t.charAt(j)) {
    //         ans = solve(i + 1, j + 1, f);
    //     } else {
    //         ans = solve(i, j + 1, f);
    //         if (f == 1) {
    //             ans |= solve(i + 1, j + 1, 0);
    //         }
    //     }
    //     dp[i][j][f] = ans ? 1 : 0;
    //     return ans;
    //  }
    //   dp = new int[n][m][2];
    //   for (int i = 0; i < n; i++) {
    //       for (int j = 0; j < m; j++) {
    //           dp[i][j][0] = dp[i][j][1] = -1;
    //         }
    //     } return solve(0, 0, 1);
 
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[] suf = new int[m + 1];
        suf[m] = n;

        int i = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            if (i >= 0 && s.charAt(i) == t.charAt(j)) i--;
            suf[j] = i + 1;
        } 
        if (suf[0] == 0) return true;

        i = 0;
        boolean used = false;

        for (int j = 0; j < m && i < n; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            } else if (!used && suf[j + 1] <= i + 1) {
                used = true;
                i++;
            }
        } 
        return i == n;
    }
}
 