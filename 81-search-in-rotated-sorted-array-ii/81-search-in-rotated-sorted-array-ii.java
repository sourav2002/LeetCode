class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        while(l <= r){
            if(target == nums[l] || target == nums[r]) return true;
            else if(target > nums[l]){
                while(l < r && nums[l+1] == nums[l]){
                    l++;
                }
                l++;
            }else if(target < nums[r]){
                while(r > l && nums[r-1] == nums[r]){
                    r--;
                }
                r--;
            }
            else{
                break;
            }
        }
        return false;
    }
}