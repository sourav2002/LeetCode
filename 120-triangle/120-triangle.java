class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        Integer[][] dp = new Integer[tri.size()][tri.size()];
         return  tri.get(0).get(0) + solve(tri,1,0, dp);
    }
    
    public int solve(List<List<Integer>> tri, int i, int j, Integer[][] dp){
        if(i == tri.size()){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int left = tri.get(i).get(j) + solve(tri, i+1, j, dp);
        int right = tri.get(i).get(j+1) + solve(tri, i+1, j+1, dp);
        dp[i][j] =  Math.min(left, right);
        return dp[i][j];
    }
}