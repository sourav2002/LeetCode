class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1,o2) -> {
            return (o2.getValue()).compareTo(o1.getValue());
        });
        
        int [] ans = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> aa : list){
            if(k == 0) return ans;
            ans[i++] = aa.getKey();
            k--;
        }
        return ans;
    }
}