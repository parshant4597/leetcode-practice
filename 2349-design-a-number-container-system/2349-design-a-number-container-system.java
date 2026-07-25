class NumberContainers {
    Map<Integer, Integer> map ; 
    Map<Integer, PriorityQueue<Integer>> pqmap;
    public NumberContainers() {
        map = new HashMap<>();
        pqmap = new HashMap<>();
    }
    
    public void change(int indx, int num) {
        map.put(indx , num);
        pqmap.computeIfAbsent(num, k -> new PriorityQueue<>()).add(indx);
    }
    
    public int find(int num) {
        if (!pqmap.containsKey(num))return -1;
        PriorityQueue<Integer> pq = pqmap.get(num);
         
        while(!pq.isEmpty()){
            int indx =  pq.poll();
            if(map.get(indx) == num){
                pq.offer(indx);
                return indx ; 
            }
        }
        System.out.println(num);
        return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */