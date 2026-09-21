import java.util.*;

class Solution {
    public long countIntersectingIntervals(int[][] intv) {
        int n = intv.length;
        List<int[]> events = new ArrayList<>(2 * n);
        
         for (int[] interval : intv) {
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1], -1});
        }
         
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);  
        });
        
        long ans = 0;
        long active = 0;
        
        for (int[] event : events) {
            if (event[1] == 1) {
                ans += active; 
                active++;
            } else {
                active--;
            }
        }
        
        return ans;
    }
}