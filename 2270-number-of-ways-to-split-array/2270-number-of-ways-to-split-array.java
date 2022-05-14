class Solution {
    public int waysToSplitArray(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        long sum = 0;
        for(int i : nums){
            sum += i;
        }
        int c =0;
        long cs = 0;
        for(int i=0; i< nums.length-1; i++){
            cs += nums[i];
            if(cs >= sum - cs){
                c++;
            }
        }
        return c;
    }
}