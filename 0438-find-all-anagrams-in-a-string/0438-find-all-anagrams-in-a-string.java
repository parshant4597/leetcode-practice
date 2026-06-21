class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n1 = p.length();
        int n2 = s.length();
        
        if (n2 < n1) return ans;

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < n1; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (matches(pCount, sCount)) {
            ans.add(0);
        }
        for (int i = n1; i < n2; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - n1) - 'a']--;
            if (matches(pCount, sCount)) {
                ans.add(i - n1 + 1);
            }
        }

        return ans;
    }
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) return false;
        }
        return true;
    }
}