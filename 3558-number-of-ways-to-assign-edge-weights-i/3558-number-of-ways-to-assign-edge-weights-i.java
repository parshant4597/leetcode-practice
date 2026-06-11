class Solution {
    int mod = (int)Math.pow(10 , 9)+  7 ; 
    int max = 0 ; 
      private long power(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    private long modularInverse(long n) {
        if (n == 2) return (mod + 1L) / 2; 
        return power(n, mod - 2);
    }

    public void solve(int edge ,ArrayList<ArrayList<Integer>> arr ,int ans ,  boolean[] vis){
        vis[edge] = true ; 
        max = Math.max(ans, max);
        for(int adj : arr.get(edge)){
            if(!vis[adj]){
               solve(adj  , arr , ans+1 , vis );
            }
        }
    }
    public int assignEdgeWeights(int[][] edges) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int n = edges.length +1 ; 
        for(int i = 0 ; i <= n ; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length  ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        } 
         
            int ans = 0 ;
            boolean[] vis = new boolean[n+1];
            solve(1 , arr , ans , vis);
          
        return (int) power(2, max-1);
        
    }
}