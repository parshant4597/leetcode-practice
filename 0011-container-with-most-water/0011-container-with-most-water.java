class Solution {
    public int maxArea(int[] arr) {
        int left = 0 ; 
        int right = arr.length - 1 ; 
        int area = 0 ; 
        while(left <= right){
            int water = Math.min(arr[left] , arr[right])*(right - left);
            area = Math.max(water   , area);
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return area  ; 

        
    }
}