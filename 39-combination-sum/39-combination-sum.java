class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(arr,target, ans, new ArrayList<Integer>(), 0,0);
        return ans;
    }
    
    public static void backtrack(int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> list, int i,int sum){
        if(i == arr.length){
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(sum < target){ // bcz we are taking same number multiple time
            list.add(arr[i]);
            sum += arr[i];
            backtrack(arr,target, ans,list,i, sum);      // <-- here       
            list.remove(list.size()-1); 
            sum -= arr[i];
        }

        backtrack(arr, target, ans,list,i+1,sum);
    }
}