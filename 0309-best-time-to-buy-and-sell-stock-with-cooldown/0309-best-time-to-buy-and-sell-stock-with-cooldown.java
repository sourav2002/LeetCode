class Solution {

    public int maxProfit(int[] p) {
        int n = p.length;
        // return rec(p, 0, 0);
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        // return memo(p,0,0,dp);
        // return tabu(p,n,0);
        return space(p, n, 0);
    }

    public static int rec(int[] arr, int i, int stock) {
        if (i >= arr.length) return 0;

        if (stock == 0) {
            return Math.max(rec(arr, i + 1, 0), -arr[i] + rec(arr, i + 1, 1));
        } else {
            return Math.max(rec(arr, i + 1, 1), arr[i] + rec(arr, i + 2, 0));
        }
    }

    public static int memo(int[] arr, int i, int stock, int[][] dp) {
        if (i >= arr.length) return 0;

        if (dp[i][stock] != -1) return dp[i][stock];
        if (stock == 0) {
            return dp[i][stock] = Math.max(memo(arr, i + 1, 0, dp), -arr[i] + memo(arr, i + 1, 1, dp));
        } else {
            return dp[i][stock] = Math.max(memo(arr, i + 1, 1, dp), arr[i] + memo(arr, i + 2, 0, dp));
        }
    }

    public static int tabu(int[] arr, int n, int stock) {
        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = dp[n + 1][0] = dp[n + 1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j], -arr[i] + dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], arr[i] + dp[i + 2][j - 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int space(int[] arr, int n, int stock) {
        int aheadBuy = 0, aheadSell = 0;
        int currBuy = 0, currSell = 0;
        int aa_buy = 0;

        for (int i = n - 1; i >= 0; i--) {
            currBuy = Math.max(aheadBuy, -arr[i] + aheadSell);
            currSell = Math.max(aheadSell, arr[i] + aa_buy);
            aa_buy = aheadBuy;
            aheadBuy = currBuy;
            aheadSell = currSell;
        }

        return aheadBuy;
    }
}
