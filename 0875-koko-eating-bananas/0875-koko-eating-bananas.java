class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0 ; 
        for(int i = 0 ; i < piles.length ; i++){
            right = Math.max(piles[i] , right);
        }
        int indx = -1; 
        while(left <= right){
            int mid = left + (right -left)/2 ; 
            if(check(mid , piles , h)){
                indx = mid ;
                right = mid - 1; 
            }else{
                left = mid +1 ;
            }
        }   
        return indx ; 
    }
    public boolean check(int mid , int[] piles , int h){
        long count = 0 ; 
        for(int i = 0 ; i < piles.length ; i++){

                count += (piles[i]+mid - 1)/mid;
        }
        return count <= h ; 
    }
}