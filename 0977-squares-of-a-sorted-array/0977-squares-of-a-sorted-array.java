class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0 ;i < nums.length ; i++){
            nums[i] = nums[i]*nums[i];
        }
        int left = 0 ; 
        int right = nums.length - 1 ;
        int[] ans = new int[nums.length ];
        int indx = right ; 
        while(left <= right){
            ans[indx] = Math.max(nums[right] , nums[left]);
                indx--;
            if(nums[left] <= nums[right]){
                right--;
            }else{
                left++;
            }
            
        }
        return ans ; 

        
    }
}