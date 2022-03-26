class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(0, ans, arr);
        return ans;
    }
    
    public void backtrack(int ind, List<List<Integer>> ans, int[] arr){
        if(ind == arr.length-1){
            
            // put all values of arr in arraylist
            List<Integer> ds = new ArrayList();
            for(int i=0; i<arr.length; i++){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i= ind; i< arr.length; i++){
            swap(i, ind, arr );
            backtrack(ind+1, ans, arr);
            swap(i, ind, arr);
        }
    }
    
    public void swap(int i, int ind, int[] arr){
        int t = arr[i];
        arr[i] = arr[ind];
        arr[ind] = t;
    }
}
/*
                                    1  2  3
                                   /   |    \
                           (swap 1) (swap 2) (swap 3)
                           
*/