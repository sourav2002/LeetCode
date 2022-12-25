class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int []ans = new int[queries.length];
        int ind = 0;
        Arrays.sort(nums);
        for (int q : queries){
            Queue<Integer> que = new LinkedList();
            int sum = 0;
            int max = 0;
            // System.out.println("-----------for value = " + q +"--------------");
            for(int i : nums){
                while(!que.isEmpty() && sum + i > q){
                    sum -= que.remove();
                    // System.out.println("sum decre = "+ sum);
                }
                if(sum < 0) sum = 0;
                if(sum + i <= q){
                    sum += i;
                    que.add(i);
                }
                max = Math.max(max, que.size());
                // System.out.println("max = "+ max);
                // System.out.println("sum = "+ sum);
                
            }
            ans[ind++] = max;
        }
        return ans;
    }
}