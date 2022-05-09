class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (start == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[start]);
        backtrack(list, tempList, nums, start + 1); // take
        tempList.remove(tempList.size() - 1); // backtrack 
        backtrack(list, tempList, nums, start + 1); // not take
    }
}
