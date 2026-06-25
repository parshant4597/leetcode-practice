class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0 ; 
        int right = 0 ; 
        int len = 0 ; 
        while(right < fruits.length){
            if(right < fruits.length && map.size() <= 2 ){
                map.put(fruits[right] , map.getOrDefault(fruits[right] ,0 )+1);
                right++;
            }
            
            if(map.size() > 2 ){
                map.put(fruits[left] , map.getOrDefault(fruits[left] ,0)-1);
                if(map.getOrDefault(fruits[left] , 0 ) <= 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            len = Math.max(right - left   ,len);
        }
        return len ; 

        
        
    }
}