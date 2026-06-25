class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> arr = new ArrayList<>();
        for(int i= 0 ; i < nums.length ; i++){
            int st = nums[i]- k ;
            int end = nums[i]+k ;
            arr.add(new int[]{st , 1});
            arr.add(new int[]{end+1 , -1});
             
        }
        Collections.sort(arr , (a, b) ->{
            if(a[0] == b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        int max = 0 ;
        int sum = 0 ; 
        for(int i = 0 ; i < arr.size() ; i++){
            sum += arr.get(i)[1];
            max  = Math.max(sum , max);

        }
        return max; 

        
    }
}