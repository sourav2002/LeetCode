class Solution {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int target = k - nums[i];
            if (map.containsKey(target) && map.get(target) > 0) {
                count++;
                map.put(target, map.get(target)-1);
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        return count;
    }
}
