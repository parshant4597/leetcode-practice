class Solution {
    public int maximumLength(int[] nums) { // adjust method name to match LeetCode's template
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        // 1. Handle the special case of 1s safely without deleting it
        if (map.containsKey(1)) {
            int count = map.get(1);
            ans = (count % 2 == 1) ? count : count - 1;
        }

        // 2. Iterate through the map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long key = entry.getKey();

            // Skip 1 since it's already processed and causes an infinite loop
            if (key == 1) {
                continue;
            }

            int len = 0;
            while (map.containsKey((int) key)) {
                int count = map.get((int) key);
                
                if (count >= 2) {
                    len += 2; // Take two elements to place at both sides of the peak
                } else {
                    len += 1; // Only 1 element left, it MUST be the peak of our pattern
                    break;
                }

                key = key * key;
                if (key > 1000000000) {
                    break;
                }
            }
            
            // If the loop finished naturally because the next square wasn't found, 
            // the last valid element we looked at must act as our peak (subtract 1)
            if (!map.containsKey((int) key) && len > 0) {
                len -= 1; 
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}