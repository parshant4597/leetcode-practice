class Solution {
    public int maximumWidth(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> width = new HashMap<>();
        //Freqency
        for (int h : nums) {
            freq.put(h, freq.getOrDefault(h, 0) + 1);
        }

        for (int key : freq.keySet()) {
            int f = freq.get(key);
            width.put(key, width.getOrDefault(key, 0) + f);
            if (f > 1) {
                width.put(2 * key, width.getOrDefault(2 * key, 0) + f / 2);
            }
        }
        // unique val ; 
        List<Integer> keys = new ArrayList<>(freq.keySet());
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                int freqA = freq.get(keys.get(i));
                int freqB = freq.get(keys.get(j));
                width.put(keys.get(i)+keys.get(j),
                width.getOrDefault(keys.get(i)+keys.get(j),0)+Math.min(freqA,freqB)
                );
            }
        }

        int maxi = 1;
        for (int val : width.values()) {
            maxi = Math.max(maxi, val);
        }
        return maxi;
    }
}