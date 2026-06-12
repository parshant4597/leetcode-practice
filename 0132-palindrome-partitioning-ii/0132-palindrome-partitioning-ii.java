class Solution {
    int[] dp ;
    public boolean ispalid(String s  , int i , int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false; 
            }
        }
        return true ; 
    }
    public int solve(String s , int indx ){
        if(indx == s.length()){
            return 0 ; 
        }
        if(dp[indx] != -1){
            return dp[indx];
        }
        int take = (int)1e9 ; 
            for(int i = indx; i < s.length() ; i++){
                 if(ispalid(s , indx , i )){
                    take = Math.min(1+ solve(s  , i+1 ) , take);
                 }
            }
        
        return dp[indx] = take  ; 
    }
    public int minCut(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp , -1);
       return  solve(s  ,  0 ) - 1;
    }
}