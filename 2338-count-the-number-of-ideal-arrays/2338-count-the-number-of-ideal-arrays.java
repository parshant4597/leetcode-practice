import java.util.Arrays;

class Solution {

    static final int N = 10005;
    static final int mod = 1_000_000_007;

    int[][] dp = new int[10001][21];
    int[][] lengths = new int[N][21];

    // lengths[j][k] --> How many unique paths are there that ends at 'j'
    // & have length of 'k'
    void CalculateUniquePathLengths() {

        for (int i = 0; i < N; i++) {
            Arrays.fill(lengths[i], 0);
        }

        for (int j = 1; j < N; j++) {

            // contribute 'j' to its every multiples
            lengths[j][1] = 1;

            for (int k = j + j; k < N; k += j) {

                for (int i = 0; i < 20; i++) {
                    lengths[k][i + 1] += lengths[j][i];
                }
            }
        }
    }

    // How many unique arrangements of length 'length'
    // & having all the values from [1...mx]
    int UniqueArrangements(int length, int mx) {

        if (length == 0)
            return (mx == 0) ? 1 : 0;

        if (mx == 0)
            return 0;

        if (dp[length][mx] != -1)
            return dp[length][mx];

        long ans = (UniqueArrangements(length - 1, mx)
                + UniqueArrangements(length - 1, mx - 1)) % mod;

        return dp[length][mx] = (int) ans;
    }

    public int idealArrays(int n, int maxValue) {

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        CalculateUniquePathLengths();

        long ans = 0;

        for (int last = maxValue; last >= 1; last--) {

            for (int j = 1; j < 21; j++) {

                long arrangementsWithEverything = UniqueArrangements(n, j);

                ans = (ans + (arrangementsWithEverything * lengths[last][j]) % mod) % mod;
            }
        }

        return (int) ans;
    }
}