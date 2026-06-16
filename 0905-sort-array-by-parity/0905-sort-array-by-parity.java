class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = 0;
        int[] ans = new int[nums.length];
        int indx = 0  ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]%2==0){
                ans[indx] = nums[i];
                indx++;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]%2 != 0){
                ans[indx] = nums[i];
                indx++;
            }
        }
         return ans ; 

    }
}