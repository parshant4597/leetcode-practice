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
            if(nums[left] <= nums[right]){
                ans[indx] = nums[right];
                indx--;
                right--;
            }else{
                ans[indx] = nums[left];
                indx--;
                left++;
            }
            
        }
        return ans ; 

        
    }
}