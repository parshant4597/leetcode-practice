class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length ; 
        int[] res =  new int[n- k +1];
        
        int left = 0 ; 
        int right = k -1 ; 
        int i = 0 ;
        while(right < n ){
            int prev = nums[left];
            boolean flag = true ; 
            for(int d = left+1 ; d <= right ; d++){
                if(prev != nums[d]-1){
                    flag = false;
                }
                prev = nums[d];
            }
            if(flag){
                res[i++] = nums[right];
            }else{
                res[i++] = -1;
            }
            right++;
            left++;
        }     
        return res ;   
    }
}