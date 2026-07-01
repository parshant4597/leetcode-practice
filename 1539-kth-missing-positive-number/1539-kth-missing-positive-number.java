class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(max , arr[i]);
        }
        int[] ans = new int[max +k+2];
        for(int i = 0 ; i < arr.length ; i++){
            ans[arr[i]]++;
        } 
        ans[0]++;
        int count = 0; 
        for(int i = 0 ; i < ans.length  ; i++){
            if(ans[i] == 0){
                count++;
            }
            if(count == k)return i ; 
        }
         
        return -1;
        
    }
}