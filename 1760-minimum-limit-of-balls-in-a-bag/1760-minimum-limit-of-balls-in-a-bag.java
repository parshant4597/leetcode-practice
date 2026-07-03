class Solution {
    public boolean check(int mid, int[] nums, int k) {
    if (mid == 0) return false;
    
    int count = 0;
    for (int num : nums) {
        // Calculate the minimum cuts needed to make all pieces <= mid
        count += (num - 1) / mid;
        
        if (count > k) return false;
    }
    return true;
}
    public int minimumSize(int[] nums, int k) {
        int left = 0 ;
        int right  = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            right = Math.max(right , nums[i]);
        }
        int indx = -1  ; 
        while(left <= right){
            int mid = (right - left)/2 + left ; 
            if(check(mid , nums , k)){
                indx = mid ; 
                right = mid - 1;  
            }else{
                left = mid + 1; 
            }
        }
        return indx ; 
        
    }
}