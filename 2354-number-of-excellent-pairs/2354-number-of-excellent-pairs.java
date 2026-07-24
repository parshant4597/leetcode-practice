import java.util.*;

class Solution {
    public long countExcellentPairs(int[] nums, int k) { 
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        } 
        int[] bits = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            bits[idx++] = Integer.bitCount(num);
        } 
        Arrays.sort(bits); 
        long ans = 0;
        int l = 0, r = bits.length - 1;
        while (l <= r) {
            if (bits[l] + bits[r] >= k) { 
                ans += 2L * (r - l) + 1;
                r--;
            } else {
                l++;
            }
        }
        
        return ans;
    }
}