// class Solution {
//     public int[] resultsArray(int[] nums, int k) {
//         int n = nums.length ; 
//         int[] res =  new int[n- k +1];
        
//         int left = 0 ; 
//         int right = k -1 ; 
//         int i = 0 ;
//         while(right < n ){
//             int prev = nums[left];
//             boolean flag = true ; 
//             for(int d = left+1 ; d <= right ; d++){
//                 if(prev != nums[d]-1){
//                     flag = false;
//                 }
//                 prev = nums[d];
//             }
//             if(flag){
//                 res[i++] = nums[right];
//             }else{
//                 res[i++] = -1;
//             }
//             right++;
//             left++;
//         }     
//         return res ;   
//     }
// }
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        // A counter to track the length of the current consecutive sequence
        int consecutiveCount = 1;
        
        for (int i = 0; i < n; i++) {
            // If not the first element, check if the current is consecutive to the previous
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                consecutiveCount++;
            } else if (i > 0) {
                // Reset to 1 if the sequence breaks
                consecutiveCount = 1;
            }
            
            // Once we have processed at least k elements, start recording results
            if (i >= k - 1) {
                if (consecutiveCount >= k) {
                    results[i - k + 1] = nums[i];
                } else {
                    results[i - k + 1] = -1;
                }
            }
        }
        
        return results;
    }
}