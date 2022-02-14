class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                result[0] = map.get(target - arr[i]);  
                result[1] = i;
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }
}