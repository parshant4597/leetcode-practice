class Solution {
    public int maxFrequency(int[] nums, int k, int numop) {
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            int st = nums[i] - k ;
            int end = nums[i]+ k ; 
            arr.add(new int[]{st  , 1});
            arr.add(new int[]{end +1, -1});
            arr.add(new int[]{nums[i] , 0});
        }
        Collections.sort(arr , (a , b) ->{
            if(a[0]== b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        int maxfreq =  0 ; 
        int count = 0;
         

        for(int i = 0 ; i < arr.size() ; i++){
            int point = arr.get(i)[0];
            count += arr.get(i)[1];
            int dup = map.getOrDefault(point , 0 );
            int aci = dup + Math.min(numop , count - dup);
            maxfreq = Math.max(maxfreq , aci);
        }
        return maxfreq ; 
        
        
         
         

 
        
    }
}