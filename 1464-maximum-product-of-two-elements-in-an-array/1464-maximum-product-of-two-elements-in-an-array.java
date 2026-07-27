class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length ; 
        int pos = (nums[n-1]-1)*(nums[n-2]-1);
        int neg = (nums[0]-1)*(nums[n-1]-1);
        return Math.max(pos , neg);
    }
}