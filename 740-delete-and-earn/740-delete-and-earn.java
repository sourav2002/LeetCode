class Solution {
    public int deleteAndEarn(int[] nums) {
        int inc = 0;
        int exc = 0;
        int[] count = new int[100001];
        for(int i : nums) count[i]++;
        
        for(int i = 0; i < 100001; i++){
            int ni = exc+count[i]*i;
            int ne = Math.max(inc, exc);
            
            inc = ni;
            exc = ne;
        }
        
        return Math.max(inc, exc);
    }
}