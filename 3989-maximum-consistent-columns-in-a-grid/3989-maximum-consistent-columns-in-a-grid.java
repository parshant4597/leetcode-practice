class Solution {
    int[][] grid ; 
    int[][] dp  ; 
    int limit ; 
    int n  , m ; 
    public boolean check(int i , int j ){
        for (int k = 0; k < n; k++) {
            if (Math.abs(grid[k][i] - grid[k][j]) > limit)
                return false;
        }
        return true;
    }
    public int solve(int i , int prev){
        if(i==m)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int res = (int)1e9;
        if(prev==-1){
             res = Math.min(res,1+solve(i+1,prev));
             res = Math.min(res,solve(i+1,i));
        }else{
             boolean c = check(i,prev);
             if(c){
                 res = Math.min(res,solve(i+1,i));
             }
             res = Math.min(res,1+solve(i+1,prev));
        }
        return dp[i][prev+1]=res;
    }
    public int maxConsistentColumns(int[][] grid, int limit) {
        this.limit = limit ; 
        this.grid = grid ; 
        n  = grid.length ;
        dp  = new int[251][252];
        m = grid[0].length ; 
         for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i] , -1);
         }
         return (m-solve(0,-1));
        
    }
}
// max diff for each element is limit ;  
// we have to remove element which is costing less to us or else use dp directly 
// like 