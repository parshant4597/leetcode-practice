class DSU{
    int[] parent ; 
    public DSU(int n ){
        parent = new int[n+1]; 
        for(int i = 0 ; i < n+1 ; i++){
            parent[i] = i ; 
        }
    }
    public int findparent(int u){
        if(u == parent[u] )return u ; 
        return parent[u] = findparent(parent[u]);
    }
    public void union(int u  , int v){
        int up = findparent(u);
        int vp  = findparent(v);
        if(up == vp)return  ; 
        
        parent[vp] = up ;
      
    }
}
class Solution {

    public int minScore(int n, int[][] roads) {
        // dsu bnao usme ek par
         
        DSU dsu  = new DSU(n);
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
             
            int cost = road[2];
             
            dsu.union(u , v);
        }
        int min = Integer.MAX_VALUE ; 
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int cost = road[2];
            if(dsu.findparent(u) == dsu.findparent(1)) min = Math.min(min , cost);
        }  
        return min;
    }
}