class Solution {
    public long minimumSteps(String s) {
        long ans = 0 ; 
        //
    
        int n = s.length() ;
        int[] suffix = new int[n];
        if(s.charAt(n-1) == '1'){
            suffix[n-1] = 0  ; 
        }else{
            suffix[n-1] = 1 ;
        }
        
         
       for(int i = s.length() - 2 ; i >= 0  ; i--){
           char ch = s.charAt(i);
            if(s.charAt(i) == '1'){
                suffix[i] = suffix[i+1];
                ans += suffix[i];
            }else{
                suffix[i] =  suffix[i+1]+1 ; 
            }
        }
        return ans ; 
    }
}
// 1 1 1 1 1 0 0 0 0 
// 1 1 1 1 0 0 0 0 1
// 1 1 1 0 0 0 0 1 1 
// 1 1 0 0 0 0 1 1 1 
// 1 0 0 0 0 1 1 1 1 
// 0 0 0 0 1 1 1 1 1 
// 

 
/**
 int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        int count = 0;
        while (right < s.length() && left < s.length()) {
            if (arr[right] == '1') {
                right++;
            } else {
                if (arr[left] == '0') {
                    while (arr[left] != '1' && left < right) {
                        left++;
                    }
                }
                if(arr[left] != arr[right] && left < right){
                    char temp = arr[right];
                    arr[right] = arr[left];
                    arr[left] = temp;
                    count++;
                    left++;
                    right++;
                }else{
                    right++;
                }
                     
            }
        }
        return count; */