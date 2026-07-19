class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();

        // positions of 1's in original string
        ArrayList<Integer> sourceOnes = new ArrayList<>();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sourceOnes.add(i);
                totalOnes++;
            }
        }

        boolean[] ans = new boolean[strs.length];

        for (int idx = 0; idx < strs.length; idx++) {
            char[] t = strs[idx].toCharArray();

            int fixedOnes = 0;
            int ques = 0;

            for (char c : t) {
                if (c == '1') fixedOnes++;
                else if (c == '?') ques++;
            }

            // impossible to match number of ones
            if (fixedOnes > totalOnes || fixedOnes + ques < totalOnes) {
                ans[idx] = false;
                continue;
            }

            int need = totalOnes - fixedOnes;

            // Replace '?' greedily
            for (int i = 0; i < n; i++) {
                if (t[i] == '?') {
                    if (need == ques) {
                        t[i] = '1';
                        need--;
                    } else {
                        t[i] = '0';
                    }
                    ques--;
                }
            }

            ArrayList<Integer> targetOnes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (t[i] == '1') targetOnes.add(i);
            }

            boolean ok = true;
            for (int i = 0; i < sourceOnes.size(); i++) {
                if (targetOnes.get(i) < sourceOnes.get(i)) {
                    ok = false;
                    break;
                }
            }

            ans[idx] = ok;
        }

        return ans;
    }
}