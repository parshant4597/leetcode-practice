class Solution {
    public boolean mid(long num , int[] m  ,long[] b){
        boolean ans = true ; 
        for(int i = 0 ; i < m.length ; i++){
            long bonus = b[i];
            long numi = num + bonus ; 
            if(numi >= m[i]){
                num = num - m[i];
                if(num < 0){
                    num = 0 ; 
                }
            }else{
                ans = false ; 
                break ; 
            }
        }
        return ans ; 
        
    }
    public long minInitialStrength(int[] monsters, int[][] b) {
        
        
        int n = monsters.length ; 
        long[] diff = new long[monsters.length];
        for(int i = 0 ; i < b.length ; i++){
            int u = b[i][0];
            int v = b[i][1];
            int k = b[i][2];
            diff[u] += k ;
            if(v+1 < n){
              diff[v+1] -= k ;    
            }
            
        }
        long[] bonus = new long[monsters.length];
        bonus[0] = diff[0];
        for(int i = 1 ; i < bonus.length ; i++ ){
            bonus[i] += bonus[i-1]+diff[i];
        } 
        // correct till point  ; 
        long left = 0; 
        long right = 0 ; 
        for(int i = 0 ; i < monsters.length ; i++){
            right += monsters[i];
        }
        long ans = right ;
        while(left <= right){
            long mid = (right  - left)/2 + left ; 
            if(mid(mid , monsters , bonus)){
                ans = mid ; 
                right = mid - 1; 
            }else{
                left = mid + 1 ;
            }
        }
        return  ans;
    }
}