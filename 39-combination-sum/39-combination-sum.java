class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        sum(res, new ArrayList<Integer>(), arr, target , 0 );
        return res;
        
    }
    
    private void sum(List<List<Integer>> res, List<Integer> current, int[] arr, int target, int start){
        if(target == 0) res.add(new ArrayList<>(current));

        else if(target > 0){
            for(int i = start; i< arr.length && target >= arr[i]; i++){ // target >= arr[i] bcz arr is sorted
                current.add(arr[i]);
                sum(res, current, arr, target - arr[i], i);
                current.remove(current.size() -1);
            }
        }// else if
    }
}