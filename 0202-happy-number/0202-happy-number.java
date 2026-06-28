class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set  = new HashSet<>();
        int num  = n ; 
        while(!set.contains(num)){
            if (num == 1) return true;
            set.add(num);
            int sum =  0 ;
            while(num > 0){
                int rem = num%10 ; 
                num = num/10 ; 
                sum += rem*rem  ; 
            } 
            num = sum ; 
        }
        return false;    
    }
}
// 4 
