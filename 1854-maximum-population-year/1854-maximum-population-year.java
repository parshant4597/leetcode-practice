class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            int st = logs[i][0];
            int end = logs[i][1];
            arr.add(new int[] { st, 1 });
            arr.add(new int[] { end, -1 });
        }
        Collections.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int year = -1;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int event = arr.get(i)[0];
            int delta = arr.get(i)[1];
            sum += delta;
            if (sum > max) {
                max = sum;
                year = event;
            }
        }
        return year;

    }
}