class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0] != 1){
            arr[0] = 1; 
        }
        int prev = arr[0];
        for(int i= 1  ; i < arr.length ; i++ ){
            int cur = arr[i];
            if (arr[i] > prev + 1) {
                arr[i] = prev + 1;
            }
            prev = arr[i]; 
        } 
        return arr[arr.length - 1];
    }
}