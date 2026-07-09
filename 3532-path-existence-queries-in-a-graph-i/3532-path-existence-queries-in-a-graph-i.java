class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length ; 
        boolean[] ans = new boolean[m];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            arr.add(new ArrayList<>());   
        }
        int[] component = new int[n];
int currId = 0;
component[0] = 0;

for (int i = 1; i < n; i++) {
    if (nums[i] - nums[i-1] > maxDiff) {
        currId++;
    }
    component[i] = currId;
}
 
for (int i = 0; i < queries.length; i++) {
    int u = queries[i][0];
    int v = queries[i][1];
    ans[i] = (component[u] == component[v]);
}
return ans ; 
    }
} 