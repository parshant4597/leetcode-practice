class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Loop terminates when left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check the local slope
            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right side
                left = mid + 1;
            } else {
                // mid could be the peak, or peak is to the left
                right = mid;
            }
        }
        
        // left and right will converge to the peak element index
        return left;
    }
}