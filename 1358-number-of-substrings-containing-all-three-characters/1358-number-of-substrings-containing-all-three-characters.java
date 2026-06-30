class Solution {
    public int numberOfSubstrings(String s) {
        int[] ls = {-1 , -1 , -1};
        int count =0;
        for(int i = 0 ; i < s.length() ; i++){
           ls[s.charAt(i) - 'a'] = i;

            if(ls[0] != -1 &&  ls[1] != -1  && ls[2] != -1){
                count = count + ( 1 + Math.min(ls[0],Math.min(ls[1],ls[2])));
            }
        }
        System.gc();
        return count;
    }
}