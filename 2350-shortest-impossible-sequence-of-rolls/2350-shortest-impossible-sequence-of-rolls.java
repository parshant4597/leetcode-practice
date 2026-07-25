class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int ans = 0;
        int min = -1;
        int indx = 0 ; 
        int count = 0; 
        while (true) {
            Map<Integer,Integer> map = new HashMap<>();
            while (indx < rolls.length && map.size() != k) {
                map.put(rolls[indx] , indx);
                indx++;
            }
            if(map.size() ==k){
                count++;
            }else{
                break ; 
            }
        }
        return count+1;

    }
}