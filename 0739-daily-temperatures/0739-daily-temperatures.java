class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans = new int[t.length];
        Stack<Integer> st = new Stack();
        int n = t.length-1;
        // System.out.println("init  = "+n);
        ans[n] = 0;
        st.push(n);
        n--;
        // System.out.println("before loop = "+ n);
        while(n >= 0){
            // System.out.println("val of n in loop = "+ n);
            // System.out.println("stack before = "+st);
            while(!st.isEmpty() && t[n] >= t[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[n] = 0;
            }else{
                ans[n] = st.peek() - n;
            }
            
            st.push(n);
            // System.out.println("stack after = "+st);
            n--;
        }
        return ans;
    }
}