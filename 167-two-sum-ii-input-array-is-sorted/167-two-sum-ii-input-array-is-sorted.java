class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length-1;
        int res[] = new int[2];
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
            else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}