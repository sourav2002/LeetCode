class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1) return nums[0];
        return solveSpaceOpti(nums, nums.length-1);
    }
    
    public static int solveSpaceOpti(int[] nums, int n){
        int two = nums[0];
        int one = Math.max(nums[0], nums[1]);
        for(int i=2; i<=n; i++){
            int pick = nums[i] + two;
            int nonpick = 0 + one;
            two = one;
            one = Math.max(pick, nonpick);
        }
        return one;
    }
}