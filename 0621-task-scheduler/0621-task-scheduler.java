class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ;i < tasks.length ; i++){
            map.put(tasks[i] , map.getOrDefault(tasks[i] , 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a , b) ->{
            return map.get(b) - map.get(a);
        });
        map.forEach((key , value) ->{
            pq.offer(key);
        });
        int count = 0 ; 
        while(!pq.isEmpty()){
            int m = pq.size();
            int size = Math.min(m , n+1);
            ArrayList<Character> extra = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
                char key = pq.poll();
                int val  = map.get(key);
                val--;
                if(val >= 1){
                    map.put(key , val);
                    extra.add(key);
                }
                count++;
            }
            for(int i = 0 ; i < extra.size() ; i++){
                pq.offer(extra.get(i));
            }
            if(size == m && !pq.isEmpty()){
                count += (n - size + 1);
            }
        }
        return count ; 
    }
}
// a - 3
// b - 2 
// c -1 
// d -1 ' 
/// n == 2 
// '