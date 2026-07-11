class DSU {

        int[] parent;
        int[] size; 
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(size, 1);
        } 
        int find(int node) {
            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        } 
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return;
            }
            if (size[root1] > size[root2]) {
                parent[root2] = root1;
                size[root1] += size[root2];
            } else {
                parent[root1] = root2;
                size[root2] += size[root1];
            }
        }
    }
public class Solution {

    public int countCompleteComponents(int n, int[][] edges) { 
        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        } 
        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }
 
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {  
                int total = dsu.size[i];
                int newtotal = (total * (total - 1)) / 2;
                if (map.getOrDefault(i, 0) == newtotal) {
                    count++;
                }
            }
        }
        return count;
    }

     
}