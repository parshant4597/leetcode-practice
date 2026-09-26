class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});   // Start event (+1)
            events.add(new int[]{interval[1], -1});  // End event (-1)
        }
        
        // Sort by position x. If positions are equal, place +1 before -1
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]); // +1 comes before -1
        });
        
        List<int[]> res = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int[] event : events) {
            if (count == 0) {
                start = event[0]; // Transition from 0: mark start
            }
            
            count += event[1];
            
            if (count == 0) {
                res.add(new int[]{start, event[0]}); // Transition back to 0: mark end
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}