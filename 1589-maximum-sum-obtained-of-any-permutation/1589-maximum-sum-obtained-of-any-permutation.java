class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] req) {
        int n = nums.length;

        List<int[]> ls = new ArrayList<>();

        for (int i = 0; i < req.length; i++) {
            int l = req[i][0];
            int r = req[i][1];

            ls.add(new int[]{l, 1});
            ls.add(new int[]{r + 1, -1});
        }

        Collections.sort(ls, (a, b) -> a[0] - b[0]);

        ArrayList<Integer> freq = new ArrayList<>();

        int active = 0;
        int prev = 0;

        for (int[] event : ls) {
            int pos = Math.min(event[0], n);

            while (prev < pos) {
                freq.add(active);
                prev++;
            }

            active += event[1];
        }

        while (prev < n) {
            freq.add(active);
            prev++;
        }

        Collections.sort(freq);
        Arrays.sort(nums);

        long ans = 0;
        long mod = 1_000_000_007L;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) freq.get(i) * nums[i]) % mod;
        }

        return (int) ans;
    }
}