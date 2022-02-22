class Solution {
    public long countPairs(int[] nums, int k) {
        long result = 0;
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcd = gcd(nums[i], k);
            for (int num : gcdMap.keySet()) {
                if ((long) gcd * num % k == 0) { // Need to convert gcd(i) * gcd(j) to long, sad java
                    result += gcdMap.get(num);
                }
            }
            gcdMap.put(gcd, gcdMap.getOrDefault(gcd, 0) + 1);
        }
        return result;
    }
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x%y);
    }
}