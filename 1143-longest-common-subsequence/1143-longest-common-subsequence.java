class Solution {

    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        return tabu(s, t, n, m);
    }

    public static int tabu(String s, String t, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        //        for(int i=0; i<n; i++){
        //            if(s.charAt(i) == t.charAt(0)) dp[i][0] = 0;
        //        }
        //        for(int j=0; j<m; j++){
        //            if(s.charAt(0) == t.charAt(j)) dp[0][j] = 0;
        //        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }
}
