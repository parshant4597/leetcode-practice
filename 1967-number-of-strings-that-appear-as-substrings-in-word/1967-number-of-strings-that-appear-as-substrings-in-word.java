class Solution {
    public int numOfStrings(String[] arr, String word) {
        int count = 0 ; 
        for(int i = 0 ; i < arr.length  ; i++){
            if(word.contains(arr[i]))count++;
        }
        return count ; 
    }
}