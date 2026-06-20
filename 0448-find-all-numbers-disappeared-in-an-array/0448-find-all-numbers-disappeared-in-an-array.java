class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] vis = new int[nums.length+1];
        for(int i = 0 ; i < nums.length ; i++){
            vis[nums[i]] = 1 ; 
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i < vis.length ; i++){
            if(vis[i] == 0)ans.add(i);
        }
        return ans ; 
    }
}