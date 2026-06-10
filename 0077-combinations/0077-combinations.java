class Solution {
    List<List<Integer>> ansList ; 
    public void solve(int indx , int[] nums , int k  , ArrayList<Integer> arr){
         
        if(arr.size() == k){
            ansList.add(new ArrayList<>(arr));
            return ; 
        }
        if(indx == nums.length){
            return  ; 
        }
        arr.add(nums[indx]);
        solve(indx +1 , nums , k , arr);
        arr.remove(arr.size() -1);
        solve(indx + 1 , nums , k , arr);
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = i +1 ; 
        }
        ansList = new ArrayList<>();
        solve(0 , nums , k , new ArrayList<>());
        return ansList ; 

        
    }
}