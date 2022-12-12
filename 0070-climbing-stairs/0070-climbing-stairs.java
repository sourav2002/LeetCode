class Solution{
    public int climbStairs(int n){
        if(n <= 2) return n;
        int a = 1;
        int b = 2;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}

/*
class Solution {
    int c = 0;
    int num;
    public int climbStairs(int n) {
        num = n;
        int[] dp = new int[n+1];
        return dfs(num, dp);
        
    }
    
    public int dfs(int n, int[] dp){
        if(n == 1 || n == 0){
            return 1 ;
        }
        if(dp[n] != 0) return dp[n];
        return dp[n] = dfs(n-1, dp) + dfs(n-2, dp);
    }
}*/