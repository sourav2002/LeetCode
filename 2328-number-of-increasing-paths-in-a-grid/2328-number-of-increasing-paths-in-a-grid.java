class Solution {
    int mod = 1000000007;
    long[][] dp;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new long[m][n];
        long ans = 0L;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, i, j, 0)) % mod;
            }
        }

        return (int) ans;
    }

    public long dfs(int[][] grid, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;

        if (grid[i][j] <= prev) return 0;

        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = 1;

        long top = dfs(grid, i - 1, j, grid[i][j]);
        long bottom = dfs(grid, i + 1, j, grid[i][j]);
        long right = dfs(grid, i, j + 1, grid[i][j]);
        long left = dfs(grid, i, j - 1, grid[i][j]);

        dp[i][j] = (top + bottom + left + right + dp[i][j]) % mod;
        return dp[i][j];
    }
}
