class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, 0, nums);
        return list;
    }
    
    
    public void backtrack(List<List<Integer>> list , int ind, int[] nums){
        if(ind == nums.length){
            List<Integer> li = new ArrayList();
            for(int i : nums){
                li.add(i);
            }
            
            list.add(li);
            return;
        }
        
        for(int i = ind; i < nums.length; i++){
            swap(i, ind, nums);
            backtrack(list, ind+1, nums);
            swap(i, ind, nums); //backtracking 
            
        }
    }
     public void swap(int i, int ind , int[] nums){
         int t = nums[i];
         nums[i] = nums[ind];
         nums[ind] = t;
     }
    
}