// dp tabulation
class Solution{
    int mod = (int) (2 * 1000000000);
    
    public int uniquePathsWithObstacles(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];
                    dp[i][j] = (up + left) % mod;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// dp memoization
/*
class Solution {
    int mod = (int) (2 * 1000000000);
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return f(grid.length-1,grid[0].length-1, grid, dp);
    }
    
    public int f(int i, int j, int[][] grid, int[][] dp){
        if(i>=0 && j>=0 && grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if( i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int up = f(i-1, j, grid, dp);
        int left = f(i, j-1, grid, dp);
        return dp[i][j] = (up + left) % mod;
    }
}
*/