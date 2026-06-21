// class Solution {
//     public int takeCharacters(String s, int k) {
//         // s = "aabaaaacaabc", k = 2
//         int[] freq = new int[3];
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);

//             freq[ch - 'a']++;

//         }
//         for (int i = 0; i < 3; i++) {
//             if (freq[i] < k)
//                 return -1;
//         }

//         int left = 0;
//         int right = s.length() - 1;
//         int[] newfreq = new int[3];
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             newfreq[ch - 'a']++;

//             boolean ans = true;
//             for (int j = 0; j < 3; j++) {
//                 if (newfreq[j] < k)
//                     ans = false;
//             }
//             left++;
//             if (ans) {
//                 break;
//             }
//         }

//         int mintime = (left - 0) + (s.length() - right - 1);
//         while (left >= 0 && right >= 0) {
//             char ch1 = s.charAt(right);
//             newfreq[ch1 - 'a']++;
//             right--;
//             while (left >= 0 && newfreq[0] <= k && newfreq[1] <= k && newfreq[2] <= k) {
//                 char ch = s.charAt(left);
//                 newfreq[ch - 'a']--;
//                 left--;
//             }
//             /**char ch1 = s.charAt(right);
//                 newfreq[ch]++;
//                 right++;  */
             
//             mintime = Math.min(mintime , (left - 0) + (s.length() - right - 1));        
//         }
//         return mintime;

//     }
// }
class Solution {
    public int takeCharacters(String s, int k) {

        int n = s.length();

        int[] total = new int[3];

        for(char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        for(int i = 0; i < 3; i++) {
            if(total[i] < k) return -1;
        }

        int left = 0;
        int maxWindow = 0;

        int[] window = new int[3];

        for(int right = 0; right < n; right++) {

            window[s.charAt(right) - 'a']++;

            while(
                window[0] > total[0] - k ||
                window[1] > total[1] - k ||
                window[2] > total[2] - k
            ) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return n - maxWindow;
    }
}