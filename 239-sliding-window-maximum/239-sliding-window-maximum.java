class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
			return new int[0];
		}
        int n = a.length;
        int[] ans = new int[n - k +1];
        int ind = 0;
        
        Deque<Integer> q = new ArrayDeque();
        for(int i = 0; i<n; i++){
            
            // remove out of range number index
            while(!q.isEmpty() && q.peek() == i- k ){
                q.poll();
            }
            
            // remove all smaller elements from queue from current element
            while(!q.isEmpty() && a[q.peekLast()] < a[i]){
                q.pollLast();
            }
            
            q.offer(i);
            if(i >= k-1){
                ans[ind++] = a[q.peek()];
            }
            
        }
        
        return ans;
    }
}