import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
         
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (countPairs(nums, mid) >= k) {
                right = mid; 
            } else {
                left = mid + 1;  
            }
        }
        
        return left;
    } 
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