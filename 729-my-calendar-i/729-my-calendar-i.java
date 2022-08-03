class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        Integer ceilingKey = calendar.ceilingKey(start);
        
        if((floorKey != null && calendar.get(floorKey) > start) 
           || (ceilingKey != null && ceilingKey < end)) return false; 
        
        calendar.put(start, end);
        return true;
    }
    
    public boolean book1(int start, int end) {
        Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
        
        if((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */