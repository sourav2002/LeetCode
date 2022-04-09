class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] res = new int[k];
        int ind = 0;

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int key : hm.keySet()) {
            int frequency = hm.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (int i = 0; i < bucket[pos].size() && ind < k; i++) {
                    res[ind++] = bucket[pos].get(i);
                }
            }
        }
        return res;
    }
}
/*
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,
            (o1, o2) -> {
                return (o2.getValue()) - (o1.getValue());
            }
        );

        int[] ans = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> aa : list) {
            if (k == 0) return ans;
            ans[i++] = aa.getKey();
            k--;
        }
        return ans;
    }
}
*/
