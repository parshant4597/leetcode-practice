class Solution {
    public long sumAndMultiply(int n1) {
        long n  = n1 ; 
        long num  = 0 ; 
        long sum = 0 ; 
        while(n >= 1){
            long rem = n %10 ; 
            n = n/10 ; 
            if(rem == 0)continue;
            num = num*10 + rem; 
            
        }
        n = num ; 
        num = 0 ; 
        while(n >= 1){
            long rem = n %10 ; 
            n = n/10 ;  
            num = num*10 + rem; 
            sum += rem; 
        } 
        return num*sum ; 

    }
}