class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pdct = 1;
        int countZero = 0;
        boolean zero = false;
        int ans[] = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                zero = true;
                countZero++;
                continue;
            }
            pdct *= nums[i];
        }
        
        if(countZero > 1){
            for(int x = 0; x< nums.length; x++){
                ans[x] = 0;
            }
            return ans;
        }

        for(int j=0; j< nums.length; j++){
            if(nums[j] != 0 && zero == false){
                ans[j] = pdct / nums[j];
            }
            else if(zero == true && nums[j] != 0){
                ans[j] = 0;
            }
            else{
                    ans[j] = pdct;
            }
        }
        
        return ans;
        
    }
}