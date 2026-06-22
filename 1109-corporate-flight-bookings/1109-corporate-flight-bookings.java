class Solution {
    public int[] corpFlightBookings(int[][] book, int n) {
        int[] ls = new int[n];
        for(int i = 0 ; i < book.length ; i++){
            ls[book[i][0]-1] += book[i][2];
            if(book[i][1] < n){
                ls[book[i][1]] -= book[i][2] ; 
            }
        }
        int[] ans = new int[n];
        ans[0] = ls[0];
        for(int i = 1 ; i < ans.length ; i++){
            ans[i] = ans[i-1]+ ls[i];
        }
        return ans; 
    }
}