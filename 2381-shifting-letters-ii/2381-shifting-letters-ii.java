class Solution {
    public String shiftingLetters(String s, int[][] nums) {
        int[] diff = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            int st = nums[i][0];
            int end = nums[i][1];
            int dir = nums[i][2];
            if (dir == 0) {
                dir = -1;
            }
            diff[st] += dir;
            if (end + 1 < s.length()) {
                diff[end + 1] -= dir;
            }
        }
        int[] diffarr = new int[s.length()];
        diffarr[0] = diff[0];
        for (int i = 1; i < s.length(); i++) {
            diffarr[i] = diffarr[i - 1] + diff[i];
        }
        System.out.println(Arrays.toString(diffarr));
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = str[i];
            // logic to change ;
            // logic to change ;
            int shift = diffarr[i] % 26;
            if (shift < 0) {
                shift += 26; 
            }
            char changed = (char) ('a' + (ch - 'a' + shift) % 26);

            str[i] = changed;

        }
        String ansres = "";
        for (int i = 0; i < s.length(); i++) {
            ansres += str[i];
        }
        return ansres;

    }
}