class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq;
        int n = nums.length;
        boolean kisless = false;
        if(k <= n/2){
            kisless = true;
            pq = new PriorityQueue<>(Collections.reverseOrder());
        }else{
            pq = new PriorityQueue();
        }
        
        for(int i : nums){
            pq.add(i);
        }
        
        int res = 0;
        int x = 0;
        if(kisless){
            x = k;
        }else{
            x = n - k +1;
        }
        while(x-- > 0){
            res = pq.poll();
        }
        return res;
    }
}