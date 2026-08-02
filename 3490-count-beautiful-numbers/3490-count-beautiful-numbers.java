// class Solution {
//     public int solve(String s , int tight , int indx , int pro , int sum){
//         if(indx == s.length()){
//             if(pro%sum == 0)return 1 ; 
//             return 0 ; 
//         }
//         int lb =  0 ; 
//         int ub = (tight == 1) ? (int)(s.charAt(indx) - '0') : 9 ;
//         int ans = 0  ;
//         for(int i = lb  ; i <= ub  ;i++){
//             sum += i ; 
//             pro = (pro*i)%sum ; 
//             ans += solve(s, (tight == 1 && i == ub) ? 1 : 0 , indx +1 , pro , sum);
//         }
//         return ans ; 
//     }
//     public int beautifulNumbers(int l, int r) {
//         String left = ""+ (l-1) ;
//         String right = ""+ r ; 
//         return solve(right ,  1 , 0 , 1 , 0 )  - solve(left   , 1 , 0 , 1 , 0);
//     }
// }
import java.util.Arrays;

class Solution {
    private int[][][] dp;

    public int beautifulNumbers(int l, int r) {
        return count(r) - count(l - 1);
    }

    private int count(int n) {
        if (n <= 0) return 0;
        String s = String.valueOf(n);
        int total = 0; 
        for (int S = 1; S <= 81; S++) {
            dp = new int[s.length()][82][82];
            for (int[][] matrix : dp) {
                for (int[] row : matrix) {
                    Arrays.fill(row, -1);
                }
            }
            total += solve(0, 0, 0, true, false, S, s);
        }

        return total;
    }

    private int solve(int idx, int sum, int rem, boolean tight, boolean isStarted, int S, String s) {
        if (idx == s.length()) { 
            return (isStarted && sum == S && rem == 0) ? 1 : 0;
        } 
        if (sum > S) return 0; 
        if (!tight && isStarted && dp[idx][sum][rem] != -1) {
            return dp[idx][sum][rem];
        }

        int limit = tight ? (s.charAt(idx) - '0') : 9;
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);
            boolean nextStarted = isStarted || (d > 0);

            int nextSum = sum + d;
            int nextRem;

            if (!isStarted) { 
                nextRem = (d > 0) ? (d % S) : 0;
            } else { 
                nextRem = (rem * d) % S;
            }

            ans += solve(idx + 1, nextSum, nextRem, nextTight, nextStarted, S, s);
        }

        if (!tight && isStarted) {
            dp[idx][sum][rem] = ans;
        }

        return ans;
    }
}