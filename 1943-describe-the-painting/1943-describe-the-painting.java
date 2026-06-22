class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {

        long[] diff = new long[100001];
        boolean[] boundary = new boolean[100001];

        for (int[] seg : segments) {
            int start = seg[0];
            int end = seg[1];
            int color = seg[2];

            diff[start] += color;
            diff[end] -= color;

            boundary[start] = true;
            boundary[end] = true;
        }

        long[] arr = new long[100001];
        arr[0] = diff[0];

        for (int i = 1; i < 100001; i++) {
            arr[i] = arr[i - 1] + diff[i];
        }

        List<List<Long>> ans = new ArrayList<>();

        int prev = -1;

        for (int i = 0; i < 100001; i++) {

            if (!boundary[i]) continue;

            if (prev != -1 && arr[prev] != 0) {
                ans.add(Arrays.asList(
                        (long) prev,
                        (long) i,
                        arr[prev]
                ));
            }

            prev = i;
        }

        return ans;
    }
}