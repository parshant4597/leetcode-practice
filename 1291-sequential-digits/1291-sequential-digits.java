class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            int num = 0; 
            int count = i; 
            while(num <= high && count <= 9  ){
                num= num*10 + count; 
                if (num >= low && num <= high) {
                    ans.add(num);
                }
                count++;
            }
            
        }
        Collections.sort(ans );
        return ans ;
        
    }
}