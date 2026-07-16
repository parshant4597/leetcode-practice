class Solution {
        public int numberOfSubstrings(String s, int k) {
        int n = s.length(), res = (n + 1) * n / 2;
        int[] count = new int[26];
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            count[c - 'a']++;
            while (count[c - 'a'] >= k) {
                char leftChar = s.charAt(i);
                count[leftChar - 'a']--;
                i++;
            }
            res -= j - i + 1;
        }
        return res;
    }
}
// Map<Character,Integer> map = new HashMap<>();
//         int count = 0 ; 
//         Map<Character , Integer> map2   = new HashMap<>();
//         boolean ok = false ; 
//         int last = s.length() ; 
//         int first = 0;
//         for(int i = 0 ; i < s.length(); i++){
//             map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
//             if(!map2.containsKey(s.charAt(i))){
//                 map2.put(s.charAt(i) , i);
//             }
//             if(map.get(s.charAt(i) ) == k){ 
//                 if(!ok){
//                     ok = true  ; 
//                     first = map2.get(s.charAt(i));
//                     last = i ; 
//                 }
//                 count += s.length() - i ; 
//                 map.put(s.charAt(i) ,map.get(s.charAt(i))-1);
//             }
//         }
//         count += first*(s.length() - last);
//         return count ; 
        