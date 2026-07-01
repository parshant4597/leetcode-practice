class Solution {
    public int maximumLength(String s) {
        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            Map<String, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            int window = i;
            for (int j = 0; j < window; j++) {
                sb.append(s.charAt(j));
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                sb.deleteCharAt(0);
                boolean ok = true;
                char c = sb.charAt(0);

                for (int k = 1; k < sb.length(); k++) {
                    if (sb.charAt(k) != c) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 3) {
                    ans = window;
                    break;
                }
            }
        }
        return (ans == 0) ? -1 : ans;

    }
}