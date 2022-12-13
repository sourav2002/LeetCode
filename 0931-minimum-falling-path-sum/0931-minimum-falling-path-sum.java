class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, f(matrix, 0, j, dp));
        }
        
        return tabu(matrix, n,m);
        // return min;
        
        
    }

    public int f(int[][] arr, int i, int j, int[][] dp) {
        if (i == arr.length - 1) return arr[i][j];
        if (dp[i][j] != 0) return dp[i][j];
        int left = (int) 1e8;
        int right = (int) 1e8;
        int down = (int) 1e8;
        if (j > 0) left = arr[i][j] + f(arr, i + 1, j - 1, dp);
        if (j < arr[0].length - 1) right = arr[i][j] + f(arr, i + 1, j + 1, dp);
        down = arr[i][j] + f(arr, i + 1, j, dp);
        return dp[i][j] = Math.min(left, Math.min(right, down));
    }

    public static int tabu(int[][] arr, int n, int m) {
        int prev[] = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[m];
            for (int j = m-1; j >=0; j--) {
                int left = (int) 1e8;
                int right = (int) 1e8;
                int up = (int) 1e8;
                if(j>0) left = arr[i][j] + prev[j-1];
                if(j < m-1) right = arr[i][j] + prev[j+1];
                up = arr[i][j] + prev[j];
                curr[j] = Math.min(left, Math.min(right, up));
            }
            prev = curr;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            mini = Math.min(mini, prev[i]);
        }
        return mini;
    }
}
