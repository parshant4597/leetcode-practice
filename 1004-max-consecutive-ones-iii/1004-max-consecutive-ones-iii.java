class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0 ; 
        int left = 0 ; 
        int right = 0 ; 
        int countk = k ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1){
                right++;
            }else{
                if(countk == 0){
                    break ; 
                }
                right++;
                countk--;
            }
        }
        ans = right - left ; 
        if(ans == nums.length )return ans ; 
        // k = 0 ; 
        while(right < nums.length && left < nums.length){
            while(left < nums.length && nums[left] != 0){
                left++;
            }
            // l0 0 0 r 
            left++;
            right++;
            while(right < nums.length && nums[right] != 0){
                right++;
            } 
            ans = Math.max(right - left, ans);
        }
        return ans ; 

        
    }
}