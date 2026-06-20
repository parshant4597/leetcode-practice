// import java.util.Arrays;

// class Solution {
//     int[] lisMemo;
//     int[] ldsMemo;

//     public int longestMountain(int[] arr) {
//         int n = arr.length;
//         if (n < 3) return 0;

//         lisMemo = new int[n];
//         ldsMemo = new int[n];
 
//         Arrays.fill(lisMemo, -1);
//         Arrays.fill(ldsMemo, -1);

//         int maxMountain = 0;

//         // A mountain peak 'i' cannot be at the very first or last index
//         for (int i = 1; i < n - 1; i++) {
//             int increase = findLIS(arr, i);
//             int decrease = findLDS(arr, i);

//             // Valid mountain peak must have both an incline and a decline
//             if (increase > 1 && decrease > 1) {
//                 maxMountain = Math.max(maxMountain, increase + decrease - 1);
//             }
//         }

//         return maxMountain;
//     }

//     // Recursive function with memoization for Increasing Subarray ending at 'i'
//     private int findLIS(int[] arr, int i) {
//         if (i == 0) return 1;
//         if (lisMemo[i] != -1) return lisMemo[i];

//         if (arr[i] > arr[i - 1]) {
//             lisMemo[i] = 1 + findLIS(arr, i - 1);
//         } else {
//             lisMemo[i] = 1;
//         }
//         return lisMemo[i];
//     }

//     // Recursive function with memoization for Decreasing Subarray starting at 'i'
//     private int findLDS(int[] arr, int i) {
//         if (i == arr.length - 1) return 1;
//         if (ldsMemo[i] != -1) return ldsMemo[i];

//         if (arr[i] > arr[i + 1]) {
//             ldsMemo[i] = 1 + findLDS(arr, i + 1);
//         } else {
//             ldsMemo[i] = 1;
//         }
//         return ldsMemo[i];
//     }
// }
import java.util.Arrays;

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int[] lisMemo = new int[n];
        int[] ldsMemo = new int[n];
        
        // Base case: every single element is a subarray of length 1
        Arrays.fill(lisMemo, 1);
        Arrays.fill(ldsMemo, 1);

        // 1. Fill lisMemo iteratively (moving forward)
        // lisMemo[i] stores the length of the longest increasing subarray ending at i
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                lisMemo[i] = 1 + lisMemo[i - 1];
            }
        }

        // 2. Fill ldsMemo iteratively (moving backward)
        // ldsMemo[i] stores the length of the longest decreasing subarray starting at i
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                ldsMemo[i] = 1 + ldsMemo[i + 1];
            }
        }

        int maxMountain = 0;

        // 3. Find the best peak using the precomputed values
        for (int i = 1; i < n - 1; i++) {
            // A valid peak must have both an incline and a decline
            if (lisMemo[i] > 1 && ldsMemo[i] > 1) {
                maxMountain = Math.max(maxMountain, lisMemo[i] + ldsMemo[i] - 1);
            }
        }

        return maxMountain;
    }
}