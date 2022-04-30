class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap();
        long total =  0;
        for(int i=0; i<n; i++){
            total += nums[i];
            map.put(i, total);
        }
        // System.out.println(total);
        // System.out.println(map);
        
        int mini = 0;
        long diff = Long.MAX_VALUE;
        for(int i=0; i< n; i++){
            long first = map.get(i) / (i+1);
            // System.out.println("first = "+ first);
            long res = 0;
            if( i != n-1){
                long second = (total - map.get(i)) / (n-i-1);
                // System.out.println("second = "+ second);
                res = Math.abs(first - second);
            }
            else{
                res  = (int) first;
            }
            // System.out.println("res = "+ res);
            if(res < diff){
                diff = res;
                mini = i;
                // System.out.println("mini is ....."+ mini);
            }
        }
        return mini;
    }
}