class Solution {
    public int solve(int[] nums , int tar){
        HashMap<Integer ,Integer> map = new HashMap<>();
        int sum = 0 ; 
        int ans = 0 ; 
        map.put(0 , -1);
        for(int  i = 0 ; i < nums.length ; i++){
             sum += nums[i];
             if(!map.containsKey(sum)){
                map.put(sum , i);
             }
             if(map.containsKey(sum - tar)){
                ans = Math.max(ans , i - map.get(sum - tar));
             }
        }
        return ans ; 
    }
    public int minOperations(int[] nums, int x) {
        // subarrau sum = (totalsum) - k 
        int sum = 0 ; 
        for(int i = 0 ; i< nums.length ; i++){
            sum += nums[i];
        }
        int tar = sum - x ;
        if(tar == 0 )return nums.length ; 
        int len = solve(nums , tar);
        if(len == 0)return -1;
        return nums.length - len ; 

    }
}