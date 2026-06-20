class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0 ; 
        int pro = 1 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0 )count++;
            if(nums[i] != 0 )pro *= nums[i];
        }
        if(count > 1){
            return new int[nums.length];
        }
        int[] ans = new int[nums.length];
        for(int i =0 ; i < nums.length ; i++){
            if(count == 1){
                if(nums[i] == 0)ans[i] = pro ; 
                else ans[i] = 0 ;
            }else{
                ans[i] = pro/ nums[i];
            }
        }
        return ans ; 
    }
}