class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000+2];
        for(int i = 0 ;i < trips.length ; i++){
            int cap = trips[i][0];
            int x = trips[i][1];
            int y = trips[i][2];
            diff[x] += cap ; 
            if(y + 1 < diff.length){
                diff[y] -= cap ; 
            } 
        }
        int[] ans = new int[diff.length];
        ans[0] = diff[0];
        if(ans[0] > capacity){
            return false;
        }
        for(int i =1 ; i < ans.length ; i++){
            ans[i] = ans[i-1] + diff[i];
            if(ans[i] > capacity){
                return false ; 
            } 
        }        
        return true ; 
        
    }
}