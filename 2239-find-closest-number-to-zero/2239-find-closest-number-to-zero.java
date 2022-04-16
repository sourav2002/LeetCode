class Solution {
    public int findClosestNumber(int[] nums) {
        int min = 9999999;
        int arg = -1;
        for(int v : nums){
            if(Math.abs(v) < min || min == Math.abs(v) && v > arg){
                min = Math.abs(v);
                arg = v;
            }
        }
        return arg;
    }
}