class MyCalendarTwo {
    ArrayList<int[]> arr ; 

    public MyCalendarTwo() {
        arr = new ArrayList<>();
        
    }
    
    public boolean book(int startTime, int endTime) {
        boolean ans = false ;
        arr.add(new int[]{startTime , 1});
        arr.add(new int[]{endTime , -1});
        Collections.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int count =0 ; 
        int sum = 0 ; 
        for(int i = 0 ; i < arr.size() ; i++){
            sum += arr.get(i)[1];
            count = Math.max(count , sum);
        }
        if (count >= 3) {
        removeEvent(startTime, 1);
        removeEvent(endTime, -1);
        return false;
        }
        return true ;
    }
    private void removeEvent(int time, int type) {
    for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i)[0] == time && arr.get(i)[1] == type) {
            arr.remove(i);
            return; // Remove only one instance
        }
    }}
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */