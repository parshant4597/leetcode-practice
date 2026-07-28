class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder s1 = new StringBuilder();
        String res = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 2) {
                s1.append((char) (i + 'a'));
            } else if (freq[i] == 1) {
                res += (char) (i + 'a');
            } else if (freq[i] > 2) {
                int mul = freq[i] / 2;
                for (int j= 0; j < mul; j++) {
                    s1.append((char) (i + 'a'));
                }

                if (freq[i] % 2 == 1) {
                    res += (char) (i + 'a');
                }

            }
        }
        return s1.toString() + res + s1.reverse().toString();

    }
}