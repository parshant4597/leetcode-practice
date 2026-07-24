class Solution {
    public int[] dfs(int node, int[] edge, int[] min) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a[0] - b[0];
                });
        // 0 time , 1 node ; 
        pq.add(new int[] { 0, node });
        for (int i = 0; i < min.length; i++) {
            min[i] = (int) 1e9;
        }
        min[node] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int topnode = top[1];
            int currtime = top[0];
            int nei = edge[topnode];
            if (nei != -1 && min[nei] >= currtime + 1) {
                min[nei] = currtime + 1;
                pq.offer(new int[] { min[nei], nei });
            }
        }
        return min;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] mintime1 = new int[edges.length];
        int[] mintime2 = new int[edges.length];
        dfs(node1, edges, mintime1);
        dfs(node2, edges, mintime2);
        int indx = -1;
        int mintime = (int) 1e9;
        for (int i = 0; i < edges.length; i++) {
            if (mintime1[i] == (int) 1e9 || mintime2[i] == (int) 1e9) {
                continue;
            }
            int max = Math.max(mintime1[i], mintime2[i]);
            if (mintime > max) {
                mintime = max;
                indx = i;
            }

        }
        return indx;

    }
}