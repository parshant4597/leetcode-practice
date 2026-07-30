// class Solution {
//     public int findMinMoves(int[] machines) {
//         int ans = 0 ; 
//         if(machines.length == 1)return 0 ; 
//         for(int i = 0  ; i < machines.length ; i++){
//             ans += machines[i];
//         }
//         if(ans == 0 )return 0 ; 
//         if(ans % machines.length != 0 )return -1;
//         ans = ans/machines.length ; 
        
//         for(int i = 0;i < machines.length ; i++){
//             machines[i] = machines[i] - ans ; 
//         }

//         int sum = 0; 
//         for(int i = 0; i < machines.length ; i++){
//             System.out.println(machines[i]);
//             sum = Math.max(machines[i] , sum);
//         }
//         int res = machines[0];
//         int lastsum = machines[0];
//         for(int i = 1; i < machines.length ; i++){
//             lastsum = Math.max(lastsum + machines[i] , machines[i]);
//             res = Math.max(lastsum , res);
//         } 
//         return Math.max(res , sum)  ;
//     }
// }
// not kadane we have to take accumaltive sum ; 
///**
public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int load : machines) {
            total += load;
        }
        
        if (total % machines.length != 0) return -1;
        
        int avg = total / machines.length;
        int cnt = 0;  
        int maxMoves = 0;
        
        for (int load : machines) {
            int diff = load - avg;
            cnt += diff; 
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(cnt), diff));
        }
        return maxMoves;
    }
} 
