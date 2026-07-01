class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        for(int i = 0 ;i < s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        int[] tfreq = new int[26];
        for(int i = 0 ;i < t.length() ; i++){
            tfreq[t.charAt(i)-'a']++; 
        } 
        for(int i = 0 ; i < 26  ; i++){
            if(tfreq[i] != freq[i])return (char)(i +'a');

        }
        return 'a';
    }
}