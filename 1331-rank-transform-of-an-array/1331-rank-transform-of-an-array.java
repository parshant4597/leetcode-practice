class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i  =  0 ; i < arr.length ; i++){
            ans[i] = arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int num = 1 ; 
        for(int i= 0 ; i < arr.length ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i] , num);
                num++;
            } 
        }
        for(int i = 0 ; i < arr.length ; i++){
            int numi = map.get(ans[i]);
            ans[i] = numi  ; 
        }
        return ans ;
        
    }
}