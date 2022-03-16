class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st= new Stack<>();
        
        int popind = 0;
        
        for(int i : pushed){
            st.push(i);
            while(popind < popped.length && !st.isEmpty()  && popped[popind] == st.peek()){
                st.pop();
                popind++;
            }
        }

        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}