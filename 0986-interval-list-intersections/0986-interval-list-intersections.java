class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0 ; i < firstList.length ; i++){
            int st = firstList[i][0];
            int end = firstList[i][1];
            arr.add(new int[]{st , 1});
            arr.add(new int[]{end+1 , -1});
        }
         for(int i = 0 ; i < secondList.length ; i++){
            int st = secondList[i][0];
            int end = secondList[i][1];
            arr.add(new int[]{st , 1});
            arr.add(new int[]{end+1 , -1});
        }
        boolean flag = true ; 
        int sum = 0 ; 
        int st = -1;
        Collections.sort(arr , (a , b)->{
            if(a[0] == b[0])return a[1] - b[1];
            return a[0] - b[0];
        });
        boolean endflag = false ; 
        ArrayList<int[]> res = new ArrayList<>();
        for(int i = 0; i < arr.size() ; i++){
            sum += arr.get(i)[1];
            if(sum == 2){
                if(flag){
                    st = arr.get(i)[0];
                    flag = false  ; 
                }
            }
            if(sum == 0 || sum == 1){
                if(st != -1 && !flag){
                    res.add(new int[]{st , arr.get(i)[0] - 1});
                    st = -1;
                    flag = true ; 
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0 ; i < res.size() ; i++){
            ans[i][0] = res.get(i)[0];
            ans[i][1]  = res.get(i)[1];
        }
        return ans;
        
    }
}