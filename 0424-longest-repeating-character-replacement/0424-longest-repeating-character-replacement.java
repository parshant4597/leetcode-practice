class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), i = 0, j = 0, maxfreq = 0;
        int freq[] = new int[26];
        int res = -1;
        while (j < n) {
            freq[s.charAt(j)-'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(j)-'A']);

            while ((j-i+1)-maxfreq > k) {
                freq[s.charAt(i)-'A']--;
                for (int l = 0; l < 26; l++) {
                    maxfreq = Math.max(maxfreq, freq[l]);
                }
                i++;
            }
            res = Math.max(j-i+1, res);
            j++;
        }
        return res;
    }
}