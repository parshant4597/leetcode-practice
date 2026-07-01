class Solution {
    public long continuousSubarrays(int[] nums) {
        // 5 4 2 4 
        // 
        long count = 0;

        int left = 0;
        int right = 0;
        Deque<Integer> minqu = new LinkedList<>();
        Deque<Integer> maxqu = new LinkedList<>();
        while (right < nums.length) {
            // minqu == 1 2 3 4 5
            while (!minqu.isEmpty() && nums[minqu.peekLast()] >= nums[right]) {
                minqu.pollLast();
            }
            // 5 4 3 2 1 
            while (!maxqu.isEmpty() && nums[maxqu.peekLast()] <= nums[right]) {
                maxqu.pollLast();
            }
            minqu.offerLast(right);
            maxqu.offerLast(right);

            while (!minqu.isEmpty() && !maxqu.isEmpty() &&
                    nums[maxqu.peekFirst()] - nums[minqu.peekFirst()] > 2) {

                left++;
                if (minqu.peekFirst() < left) {
                    minqu.pollFirst();
                }
                if (maxqu.peekFirst() < left) {
                    maxqu.pollFirst();
                }
            }
            count += right - left+1;
            right++;

        }
        return count;

    }
}