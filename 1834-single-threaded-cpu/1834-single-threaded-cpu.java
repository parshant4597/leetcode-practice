// class Solution {
//     public int[] getOrder(int[][] tasks) {
//         int indx = 0 ;  
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) ->{
//             if(a[0] == b[0]){
//                 if(a[1] == b[1]){
//                     return a[2] - b[2];
//                 }
//                 return a[1] - b[1];
//             }
//             return a[0] - b[0];
//            }
//         );
//         for(int i =  0 ; i < tasks.length ; i++){
//             int time = tasks[i][0];
//             int process  = tasks[i][1];
//             pq.offer(new int[]{time , process , i});
//         }
//         int endtime = 0 ;  
//         int[] ans = new int[tasks.length];
//         while(!pq.isEmpty()){
//             int[] task = pq.poll();
//             int time = task[0];
//             int process  = task[1];
//             int i = task[2];
//             if(time >= endtime){
//                 ans[indx] = i ; 
//                 indx++; 
//                 endtime = time + process ; 
//             }else{ 
//                 pq.offer(new int[]{endtime , process , i} );
//             }
//         }
//         return ans ;    
//     }
// }
// TC = O(nlogn)
// SC = O(n)

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task [] arr = new Task[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = new Task(i, tasks[i][0],tasks[i][1]);
        }

        Arrays.sort(arr, (a,b)->{
            return Integer.compare(a.enqueueTime,b.enqueueTime);
        });

        PriorityQueue<Task> p = new PriorityQueue<>((a,b)->{
            if(a.processingTime == b.processingTime){
                return Integer.compare(a.idx,b.idx);
            }
            return Integer.compare(a.processingTime,b.processingTime);
        });
        
        int[] ans = new int[n];
        int ansIdx = 0;
        int taskIdx = 0;
        int curTime= 0;

        while(ansIdx < n){
            while(taskIdx < n && arr[taskIdx].enqueueTime <= curTime){
                p.offer(arr[taskIdx++]);
            }
            if(p.isEmpty()){
                curTime = arr[taskIdx].enqueueTime;
            }else{
                curTime += p.peek().processingTime;
                ans[ansIdx++] = p.poll().idx;
            }
        }
        return ans;       
    }
    
    class Task {
        int idx;
        int enqueueTime;
        int processingTime;

        Task(int idx , int en , int pro){
            this.idx = idx;
            this.enqueueTime = en;
            this.processingTime = pro;
        }
    }
}