class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int ans = 0;
        int sum = 0;
        
        for(int i=0, j =0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(nums[i])){
                int x = Math.max(j, map.get(nums[i]) +1);
                while(j != x){
                    sum -= nums[j];
                    j++;
                }
            }
            map.put(nums[i], i);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}