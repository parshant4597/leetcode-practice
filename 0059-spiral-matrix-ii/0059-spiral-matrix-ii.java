class Solution {
    public void solve(int x , int y , int dir , int[][] matrix , int num){
        int n = matrix.length ; 
        if (x < 0 || x >= n || y < 0 || y >= n) return;
        if(matrix[x][y] == 0) matrix[x][y] = num ; 
        else return ; 
        num++;


        if(dir == 1){
            if(y +1 == n || matrix[x][y+1] != 0  ){
                solve(x +1 , y , 2 , matrix , num);
            }else{
                solve(x , y+1 , 1 , matrix , num);
            }
        }else if(dir == 2){
            if(x +1 == n || matrix[x+1][y] != 0  ){
                solve(x  , y - 1, 3 , matrix , num);
            }else{
                solve(x +1, y  , 2 , matrix , num);
            }
        }else if(dir == 3){
            if(y- 1 < 0 || matrix[x][y-1] != 0 ){
                solve(x-1 , y , 4 , matrix , num);
            }else{
                solve(x , y - 1  , 3 , matrix , num);
            }
        }else{
            if(x-1 < 0 || matrix[x-1][y] != 0 ){
                solve(x , y +1  , 1 , matrix , num);
            }else{
                solve(x - 1 ,y , 4 , matrix , num);
            }
        }

    }
    public int[][] generateMatrix(int n) {
        int[][] matrix  = new int[n][n];
        solve(0 , 0 , 1 , matrix , 1);
        return matrix ;
    }
}
