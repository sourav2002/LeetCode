class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int hi = nums.length-1;
        // 1) boundary check.
        if(hi == 0) return nums[hi];
        if(nums[0] != nums[1]) return nums[0];
        else if(nums[hi] != nums[hi-1]) return nums[hi];
        
        while(low <= hi){
            int mid = low+hi >>> 1;
            
            // 2) unique element property
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];
            
            // 3) partition property
            if((mid %2 == 0 && nums[mid] == nums[mid+1] )|| (mid%2 == 1 && nums[mid] == nums[mid-1])){
                low = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }
}