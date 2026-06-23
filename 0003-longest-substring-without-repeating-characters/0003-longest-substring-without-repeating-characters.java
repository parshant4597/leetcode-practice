class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int r = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();
        while (left < n &&  r < n) {
            int count = 0;
            while (r < n) {
                char ch = s.charAt(r);
                if (!set.contains(ch)) {
                    set.add(ch);
                    r++;
                } else {
                    break;
                }
            }
            set.remove(s.charAt(left));
            len = Math.max(len, r - left); 
                left++;
        
        }
        return len;
    }
}