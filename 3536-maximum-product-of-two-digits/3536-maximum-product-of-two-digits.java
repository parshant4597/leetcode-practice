class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n > 0 ){
            int rem = n %10 ; 
            n = n/10 ; 
            arr.add(rem);

        }
        Collections.sort(arr);
        return arr.get(arr.size()-1)*arr.get(arr.size()-2);
    }
}