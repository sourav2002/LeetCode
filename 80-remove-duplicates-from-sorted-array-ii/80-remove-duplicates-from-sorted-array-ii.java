/*
here we just have to return the length of modified array (after replacing duplicate numbers with next number)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
// if array contains 0 or 1 or 2 elements only then for sure there is not any duplicate elemetns with freq > 2
        if(n<3){
            return n;
        }
        
        // now take 2 pointer slow and fast start from index 2 (ignore 0 and 1 bcz no need to check for duplication)
        int s=2, f = 2;
        
        // fast pointer should not exceed the length of array
        while(f<n){
            if(nums[f] != nums[s-2]){ 
                nums[s++] = nums[f];
            }
            // dry run of if condition - 
            // [1,1,1,2,2,3] -> slow and fast is at 2nd index, nums[2]== nums[0] (acc to if conditon) so increment f
            // now fast is at 3rd index ..nums[3] != nums[1] --> update nums[s] --> [1,1,(2),2,2,3] and s++, f++
            f++;
        }
        return s;
    }
}