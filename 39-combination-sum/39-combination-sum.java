class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(arr,target, ans, new ArrayList<Integer>(), 0,0);
        return ans;
    }
    
    public static void backtrack(int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> list, int i,int sum){
        if(sum > target) return;
        if(i == arr.length){
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        // if(sum < target){ // bcz we are taking same number multiple time
            list.add(arr[i]);
            sum += arr[i];
            backtrack(arr,target, ans,list,i, sum);      // <-- here       
            list.remove(list.size()-1); 
            sum -= arr[i];
        // }

        backtrack(arr, target, ans,list,i+1,sum);
    }
}
/*
if we dont use if(sum < target ) condition then everytime backtrack for same value is called then it is gonna add sum += arr[i] and it will never stop means stackoverflow. so we only take same value until we get the target 

*/