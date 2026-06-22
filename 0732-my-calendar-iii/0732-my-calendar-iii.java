class MyCalendarThree {
    ArrayList<int[]> arr ; 
    public MyCalendarThree() {
        arr = new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
        arr.add(new int[]{startTime , 1});
        arr.add(new int[]{endTime , -1});
        Collections.sort(arr , (a , b) ->{
            if(a[0] == b[0]){
                return a[1]  - b[1];
            }
            return a[0] - b[0];
        });
        int sum = 0 ; 
        int max = 0; 
        for(int i = 0  ; i < arr.size() ; i++){
            sum += arr.get(i)[1];
            max   = Math.max(max, sum);
        }
        
        return max ;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */