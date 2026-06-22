import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeMap<Integer, Integer> lineSweep = new TreeMap<>();
         
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
             
            lineSweep.put(x - k, lineSweep.getOrDefault(x - k, 0) + 1);
            lineSweep.put(x + k + 1, lineSweep.getOrDefault(x + k + 1, 0) - 1); 
            lineSweep.put(x, lineSweep.getOrDefault(x, 0) + 0);
        }
        
        int ans = 0;
        int currentOverlapping = 0;
         
        for (Map.Entry<Integer, Integer> entry : lineSweep.entrySet()) {
            int point = entry.getKey();
            currentOverlapping += entry.getValue();
            int exactCount = cnt.getOrDefault(point, 0); 
            int achievable = exactCount + Math.min(numOperations, currentOverlapping - exactCount);
            ans = Math.max(ans, achievable);
        }
        
        return ans;
    }
}