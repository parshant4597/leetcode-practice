class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        Map<Integer  , Character> map = new HashMap<>();
        int k = 0;
        for (int i = 0; i < 26; i++) {
            map.put(i, (char) ('z' - k));  
            k++;
        }
        String res  = "";
        for(int i = 0 ; i < words.length ; i++){
            int sum = 0 ; 
            for(int j = 0 ; j < words[i].length() ; j++){
                sum += weights[words[i].charAt(j) - 'a'];
            }
            int rem = sum % 26 ;
            res += map.get(rem); 
        }
        return res ;
        
    }
}