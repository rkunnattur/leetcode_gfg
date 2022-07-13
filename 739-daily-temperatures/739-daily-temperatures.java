class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st = new Stack<>();
        int[] noOfDays = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int days = st.pop();
                noOfDays[days] = Math.abs(i - days);   
            } 
            
             st.push(i);     
        }
        
        return noOfDays;
    }
}

