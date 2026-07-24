class Solution {
    int ans = -1;
    public void dfs(boolean[] vis ,int node ,  int[] edges ,HashMap<Integer, Integer> map ){
        vis[node] = true ;
        int nei = edges[node];
        if(nei != -1 && !vis[nei]){  
            map.put(nei , map.get(node)+1);
            dfs(vis , nei , edges , map);
        }else if(nei != -1 && map.containsKey(nei)){
            ans = Math.max(ans, map.get(node) - map.get(nei) + 1);
        }
    }
    public int longestCycle(int[] edges) {
        int n = edges.length ;
        int[] in = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            int node = edges[i];
            if(node == -1)continue;
            in[node]++;
        }
        boolean[] vis = new boolean[n];
        for(int i = 0 ;i < n ; i++){
            vis[i] = false ; 
        }
        for(int i = 0 ; i < edges.length ; i++){
            if(!vis[i] && in[i] > 0 && edges[i] != -1 ){
                HashMap<Integer, Integer> map= new HashMap<>();
                map.put(i , 1);
                dfs(vis  ,i ,  edges , map);
            }
        }
        return ans ; 

    }
}