class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = -100000; 
        int n = nums.length  ;
        for(int i  = 0 ; i < n ; i++){
            int start = i+1 ; 
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];

                if(Math.abs(target -sum) < Math.abs(target - ans)){
                    ans = sum ; 
                }
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return ans;
    }
}