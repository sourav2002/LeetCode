class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];
        
        // use do while loop to avoid 1st iteration where slow and fast is already equals.
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
        
        
        
// there is one extra num so find actual sum of without extra num, means  n-1
// 1,3,4,2,2  n = 5
// after n-1
// 1+2+3+4 
// assumed = 10
// actual sum = 12
// actual - assumed = 2;
// return 2
        /*
        int n = nums.length-1;
        long assumedSum = n*(n+1)/2;
        long sum = 0;
        
        for(int num : nums){
            sum += num;
        }
        
        Long diff = sum - assumedSum;
        return diff.intValue();
        */
    }
}