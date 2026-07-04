class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    public int findparent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findparent(parent[u]);
    }

    public void union(int u, int v) {
        int up = findparent(u);
        int vp = findparent(v);

        if (up == vp)
            return;

        parent[vp] = up;
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {

        DSU dsu = new DSU(n);

        for (int[] road : roads) {
            dsu.union(road[0], road[1]);
        }

        int ans = Integer.MAX_VALUE;

        for (int[] road : roads) {
            if (dsu.findparent(road[0]) == dsu.findparent(1)) {
                ans = Math.min(ans, road[2]);
            }
        }

        return ans;
    }
}