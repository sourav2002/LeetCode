class Solution {
    public int minDeletion(int[] nums) {
        int c =0;
        
        for(int i=0; i< nums.length-1; i++){
            if((i-c) % 2 == 0 && nums[i] == nums[i+1]){  
                // i-c to shift index to left c  times bcz we deleted c times
                c++;
            }
        }
        if((nums.length - c) % 2 != 0) c++;
        return c;
        
    }
    
}

/*
1). every time we find a duplicate we will increment ans by 1.

2). thus to check the second condition we will subtract the ans value from the index as we are shifting the element to the left.

3). for the last edge case we will check the remaining size after removing ans element from the vector if the result is odd we have to remove 1 more element else just return the ans.
Code :-

*/