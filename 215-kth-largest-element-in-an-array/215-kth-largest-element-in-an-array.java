class Solution{
    public int findKthLargest(int[] nums, int k){
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    public int quickSelect(int[] nums, int l, int r, int k){
        int p = l, pivot = nums[r];
        for(int i= l; i< r; i++){
            if(nums[i] <= pivot){
                swap(nums, i, p);
                p+=1;
            }
        }
        
        swap(nums, p, r); // change pivot with latest pth position
        if(k < p){
            return quickSelect(nums, l, p-1, k);
        }else if(k > p){
            return quickSelect(nums, p+1, r, k);
        }else return nums[p];
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}



/*
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
*/