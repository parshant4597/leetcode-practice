import java.util.*;

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        // 1. Deduplicate nums using a Set
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        } 
        long[] bitCounts = new long[32];
        for (int num : uniqueNums) {
            bitCounts[Integer.bitCount(num)]++;
        }
         
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (i + j >= k) {
                    ans += bitCounts[i] * bitCounts[j];
                }
            }
        }
        
        return ans;
    }
}