class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if (k <= 1) return 0;

        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;
        int n = arr.length;

        while (right < n) { 
            product *= arr[right];
            while (product >= k) {
                product /= arr[left];
                left++;
            } 
            count += (right - left + 1);

            right++;
        }

        return count;
    }
}
