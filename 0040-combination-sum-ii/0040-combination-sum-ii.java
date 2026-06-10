class Solution {
    List<List<Integer>> ansList ; 
    public void solve(int indx, int[] arr  , int sum , ArrayList<Integer> ans){
        if(indx == arr.length){
            if(sum == 0 && !ansList.contains(ans)){
                ansList.add(new ArrayList<>(ans));
                return  ;
            }else{
                return  ;
            }
        }
        if(sum < 0){
            return  ; 
        }
        int next = indx; 
        // 2 2 3
        while(next + 1 < arr.length && arr[next] == arr[next+1]){
            next = next + 1 ; 
        }
        ans.add(arr[indx]);
        solve(indx +1 , arr, sum - arr[indx] , ans);
        ans.remove(ans.size() -1);
        solve(next+1 , arr , sum , ans);
    }
    public List<List<Integer>> combinationSum2(int[] arr, int sum) {
        ansList = new ArrayList<>();
        Arrays.sort(arr);
        solve(0 , arr , sum , new ArrayList<>());
        return ansList ; 
    }
}
// class Solution {

//     public List<List<Integer>> combinationSum2(int[] arr, int sum) {
//         List<List<Integer>> list = new LinkedList<List<Integer>>();
//         Arrays.sort(arr);
//         backtrack(list, new ArrayList<Integer>(), arr, sum, 0);
//         return list;
//     }

//     private void backtrack(
//             List<List<Integer>> answer,
//             List<Integer> tempList,
//             int[] arr,
//             int sum,
//             int index) {
//         if (sum < 0)
//             return;
//         else if (sum == 0) { 
//             answer.add(new ArrayList<>(tempList));
//         } else {
//             for (int i = index; i < arr.length && sum >= arr[i]; i++) {
//                 if (i > index && arr[i] == arr[i - 1])
//                     continue;
//                 // Add it to tempList.
//                 tempList.add(arr[i]);
//                 // Check for all possible scenarios.
//                 backtrack(
//                         answer,
//                         tempList,
//                         arr,
//                         sum - arr[i],
//                         i + 1);
//                 // Backtrack the tempList.
//                 tempList.remove(tempList.size() - 1);
//             }
//         }
//     }
// }