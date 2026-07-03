import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            left = Math.min(left, edge[2]);
            right = Math.max(right, edge[2]);
        }

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(mid, adj, online, k)) {
                ans = mid;
                left = mid + 1;      // maximize answer
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int mid,
                          ArrayList<ArrayList<int[]>> adj,
                          boolean[] online,
                          long k) {

        int n = online.length;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            int node = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[node]) continue;

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int wt = edge[1];

                if (wt < mid) continue;

                 if (next != n - 1 && !online[next]) continue;

                if (cost + wt > k) continue;

                if (dist[next] > cost + wt) {
                    dist[next] = cost + wt;
                    pq.offer(new long[]{next, dist[next]});
                }
            }
        }

        return dist[n - 1] <= k;
    }
}