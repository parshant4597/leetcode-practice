class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
        }
        int indx = -1; 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (check(mid, n, arr)) {
                indx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } 
        return indx;
    }

    public boolean check(int mid, int n, int[] arr) {
        int count = 0;
        if(mid == 0)return true ; 
        for (int i = 0; i < arr.length; i++) {
           count += (arr[i] + mid - 1) / mid;
        }
        return count <= n;

    }
}
