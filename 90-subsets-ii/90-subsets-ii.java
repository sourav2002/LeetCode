class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>() , nums, 0);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] arr, int ind){
        
        if(ind == arr.length) {
            if(!list.contains(temp))
            list.add(new ArrayList(temp));
            return;
        }
        
        temp.add(arr[ind]);
        backtrack(list, temp, arr, ind+1);
        temp.remove(temp.size()-1);
        backtrack(list, temp, arr, ind+1);
        
    }
}