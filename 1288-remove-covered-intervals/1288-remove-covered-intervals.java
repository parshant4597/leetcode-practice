class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        int count= 0 ; 
        Arrays.sort(arr , (a , b) ->{
            if(a[0] == b[0])return b[1] - a[1];
            return a[0] - b[0];
        });
        int end = arr[0][1];
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i][1]  <= end){
                count++;
            }else{
                end  = arr[i][1];
            }
        }
        return arr.length -  count ;
    }
}
// class Solution {
//     public int removeCoveredIntervals(int[][] arr) {
//         int count = 0 ; 
        
//         Set<String> set = new HashSet<>();
//         for(int i = 0 ; i < arr.length ; i++){
//             int st = arr[i][0];
//             int end = arr[i][1];
//              for(int j = 0 ; j < arr.length ; j++){
//                 if(i == j)continue;
//             int st1 = arr[j][0];
//             int end1 = arr[j][1];
//                 if(arr[i][0] <= arr[j][0] && arr[i][1] >= arr[j][1]){
//                     if(!set.contains(st1 + " " + end1)){
//                         set.add(st1 + " " + end1);
//                     }
//                 }
//              }
//         }
//         return arr.length - set.size();
        
//     }
// }