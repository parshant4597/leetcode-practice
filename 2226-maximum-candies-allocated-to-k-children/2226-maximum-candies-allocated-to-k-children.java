class Solution {
    public boolean check(int mid , int[] arr  , long k ){
        if(mid == 0)return true  ; 
        long count= 0 ; 
        for(int i =  0 ; i < arr.length ; i++){

            count += (arr[i]/mid);
        }
        if(count >= k)return true ; 
        return false ; 

    }
    public int maximumCandies(int[] arr, long k) {
        int left = 0 ; 
        int right = 0 ; 
        for(int i = 0 ; i < arr.length ; i++){
            right = Math.max(right , arr[i]);
        }
        int indx = 0;
        while(left <= right){
            int mid = (right - left)/2 + left ; 
            if(check(mid , arr , k)){
                indx = mid ; 
                left = mid + 1  ; 
            }else{
                right = mid - 1 ; 
            }

        }
        return indx ; 


        
    }
}