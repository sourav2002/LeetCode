class Solution {
    public int minDeletion(int[] nums) {
        int c =0;
        
        for(int i=0; i< nums.length-1; i++){
            if((i-c) % 2 == 0 && nums[i] == nums[i+1]){  
                c++;
            }
        }
        if((nums.length - c) % 2 != 0) c++;
        return c;
        
    }
    
}