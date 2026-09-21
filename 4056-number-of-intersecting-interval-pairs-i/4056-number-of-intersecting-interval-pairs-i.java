 
class Solution {
    public int countIntersectingIntervals(int[][] intv ) {
        long count = 0 ; 
        int n = intv.length ; 
        
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++ ){
            int st = intv[i][0];
            int end = intv[i][1];
            arr.add(new int[]{st , 1});
            arr.add(new int[]{end , -1});
        }
        Collections.sort(arr , (a , b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        long sum = 0 ;  
        for(int i = 0 ; i < arr.size() ; i++){
            System.out.println(arr.get(i)[0] + " * " + arr.get(i)[1] );
            if(arr.get(i)[1] == 1){
                count += sum ;
                sum++;
            }else{ 
                sum--; 
            }          
        }
        return (int)count ; 
        
    }
}
/**
import java.util.*;

class Solution {
    public long countIntersectingIntervals(int[][] intv) {
        int n = intv.length;
        List<int[]> events = new ArrayList<>(2 * n);
        
         for (int[] interval : intv) {
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1], -1});
        }
         
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);  
        });
        
        long ans = 0;
        long active = 0;
        
        for (int[] event : events) {
            if (event[1] == 1) {
                ans += active; 
                active++;
            } else {
                active--;
            }
        }
        
        return ans;
    }
}

 */