class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for(String s: tokens) {
            if(operator.contains(s)) {
                int operand2 = st.pop();
                int operand1 = st.pop();
                if(s.equals("+")) {
                    st.push((operand1 + operand2));
                }else if(s.equals("-")) {
                   st.push((operand1 - operand2)); 
                }else if(s.equals("*")) {
                    st.push((operand1 * operand2));
                }else if(s.equals("/")) {
                    st.push((operand1 / operand2));
                }
            } else st.push(Integer.parseInt(s));
            
        }
        
        return st.pop();
    }
}