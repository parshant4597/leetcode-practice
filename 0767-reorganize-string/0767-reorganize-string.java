class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        if(n == 1)return s ; 
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) ->{
            return freq[b] - freq[a];
        });
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        } 
        for(int i = 0 ; i < 26 ; i++){ 
            if(freq[i] > 0 ){
                pq.offer(i);
            }
        }
        char[] str  = new char[n];
        int i = 0 ; 
        while(!pq.isEmpty()){
            int top = pq.poll();
            char ch = (char)(top + 'a');
            int map = freq[top];
            while(i < n && map-- > 0 ){
                str[i] = ch ; 
                i += 2;
                if(i >= n){
                    i = 1  ; 
                }
            }
        }
        String ans = "";
        ans += str[0];
        for(int k = 1 ; k < n - 1 ; k++ ){
            if(str[k] == str[k-1] || str[k] == str[k+1]){
                return "";
            }
            ans += str[k];
        }  
        ans += str[n-1];
        
        return ans;

        

        
    }
}