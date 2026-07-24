class Solution {
    public int uniqueXorTriplets(int[] arr) { 
        HashSet<Integer> setarr = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            setarr.add(arr[i]);
        }
        int[] nums = new int[setarr.size()];
        int m = 0 ; 
        for(int i : setarr){
            nums[m++] = i ; 
        }
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length ; j++){
                set.add(nums[i] ^ nums[j]);
            }
        }
        for(int xor : set){
            for(int i = 0 ; i < nums.length ; i++){
                  ans.add(xor^nums[i]);
            }
        }
        return ans.size();
    }
    
}