import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // 1. Sort the array so we can use a sliding window
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        
        // 2. Binary search on the distance range
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Count how many pairs have a distance <= mid
            if (countPairs(nums, mid) >= k) {
                right = mid; // Try to find a smaller valid distance
            } else {
                left = mid + 1; // The distance is too small
            }
        }
        
        return left;
    }
    
    // Helper function to count pairs with distance <= target using sliding window
    private int countPairs(int[] nums, int target) {
        int count = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            count += (right - left);
        }
        
        return count;
    }
}
/**
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            return b - a; 
        });
        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                pq.offer(Math.abs(nums[i] - nums[j]));
                if(pq.size() > k)pq.poll();
            }
        }
         
        return pq.poll();
         */