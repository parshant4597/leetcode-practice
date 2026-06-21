class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        HashMap<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n1; i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i <= n2 - n1; i++){ // changed from < to <=
            HashMap<Character , Integer> map2 = new HashMap<>();
            
            for(int j = i ; j < i + n1 ; j++){ // fixed loop variable (was incorrectly using i++)
                map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1); // was wrongly using map instead of map2
            }

            int count = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();

                if (map2.containsKey(key) && map2.get(key).equals(value)) {
                    count++;
                }
            }

            if (count == map.size()) {
                return true;
            }
        }
        return false;
    }
}
