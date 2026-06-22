class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] req) {
        int n = nums.length;

        
        int[] ls = new int[nums.length+1];

        for (int i = 0; i < req.length; i++) {
            int l = req[i][0];
            int r = req[i][1];

            ls[l]++;
            ls[r+1]--;
        }
 

        int[] actualFreq = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ls[i];
            actualFreq[i] = sum;
        }

        Arrays.sort(actualFreq);
        Arrays.sort(nums);

        long ans = 0;
        long mod = 1_000_000_007L;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) actualFreq[i] * nums[i]) % mod;
        }

        return (int) ans;
    }
}