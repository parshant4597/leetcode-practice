class Solution {
    public int prefixCount(String[] words, String pref) {
        // int count   = 0 ;
        // int len = pref.length(); 
        // for(int i = 0 ; i < words.length ; i++){
        //     if(len > words[i].length())continue ;
        //     String sub = words[i].substring(0 , len);
        //     if(sub.equals(pref))count++;
        // }
        // return count ; 
         int count = 0;

        for(String word : words){
            if(word.startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}