class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for(int i=0; i<n; i++){
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() +1;
            st.push(i);
        }
        // clear the stack to be re-used
        while(!st.empty()) st.pop();
        for(int i=n-1; i>=0; i--){
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
                                                  
            if(st.empty()) rightSmall[i] = n-1;
            else rightSmall[i] = st.peek() - 1;                      
                           
            st.push(i);
        }
        
        int maxA = 0;
        for(int i=0;i<n;i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}