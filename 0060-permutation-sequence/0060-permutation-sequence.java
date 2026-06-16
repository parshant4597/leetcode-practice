class Solution {
    ArrayList<String> ansList;

    public void solve(int indx, int n, int k, StringBuilder sb) {

        if (sb.length() == n) {
            ansList.add(sb.toString());
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (i != indx && sb.indexOf(String.valueOf((char) (i + '0'))) == -1) {
                sb.append((char) (i + '0'));
                solve(i, n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String getPermutation(int n, int k) {
        // first number v find karle ta 
        ansList = new ArrayList<>();
        long pro =  1 ; 
        for(int i = 1 ; i < n  ; i++){
            pro *= i ; 
        }
        int indx = 0;
        int st = 0 ; 
        int end = (int)pro ;  
        while(true){
            if(k >= st && k <= end){
                break ; 
            }
            st += pro ; 
            end += pro ; 
            indx++;
        }
        indx++;
       
        StringBuilder sb = new StringBuilder();
        sb.append((char)(indx+'0')); 
        solve(indx, n, k, sb);
        return ansList.get(k - st  - 1).toString();

    }
}