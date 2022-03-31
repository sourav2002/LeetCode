class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for(int i : nums){
            sum += i;
            max = Math.max(max , i);
        }
        if(m == nums.length){
            return max;
        }
        int low = max;
        int hi = sum;
        int ans = 0;
        
        while(low <= hi){
            int mid  = low +(hi - low)/2;
            if(isPossible(nums, mid, m) == true) {
                ans = mid;
                hi = mid -1;
            }else{
                low = mid +1;
            }
        }//while end
        
        return ans;
    }
    
    public static boolean isPossible(int[] arr, int mid, int m){
        int subArrayCount = 1;
        int sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
            
            if(sum > mid){
                subArrayCount++;
                sum = arr[i];
            }
        }
        
        if(subArrayCount <= m){
            return true;
        }
        return false;
    }
}