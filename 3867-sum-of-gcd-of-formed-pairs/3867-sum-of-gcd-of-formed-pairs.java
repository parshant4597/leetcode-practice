class Solution {
    public int gcd(int a , int b){
        while(b!= 0){
            int temp = b;
            b = a%b ;
            a= temp ;
        }
        return a ; 
    }
    public long gcdSum(int[] nums) {
        int n = nums.length ; 
        int[] premax = new int[nums.length ];
        int[] pregcd = new int[n];
        premax[0] = nums[0];
        for(int i = 1 ;i < n ;i++){
            premax[i] = Math.max(premax[i-1] , nums[i]); 
        }
        for(int i = 0 ; i < n ; i++){
             pregcd[i] = gcd(nums[i] , premax[i]);
             // corret till this point : System.out.println(pregcd[i]);
        }
        Arrays.sort(pregcd);
        int left = 0 ; 
        int right = n-1;
        long sum = 0 ; 
        while(left < right){
            int num = gcd(pregcd[left] , pregcd[right]);
            sum += num ; 
            left++;
            right--;  
        }
        return sum ; 
    }
}