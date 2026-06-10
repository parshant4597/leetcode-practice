class Solution {
    int n ; 
    List<List<Integer>> ansList ; 
    public void solve(int indx , int k  , ArrayList<Integer> arr){
         
        if(k == 0 ){
            ansList.add(new ArrayList<>(arr));
            return ; 
        }
        if(indx == n+1){
            return  ; 
        }
        arr.add(indx);
        solve(indx +1   , k - 1 , arr);
        arr.remove(arr.size() -1);
        solve(indx + 1   , k , arr);
    }
    public List<List<Integer>> combine(int n, int k) {
         this.n = n ; 
        ansList = new ArrayList<>();
        solve(1  , k , new ArrayList<>());
        return ansList ; 

        
    }
}