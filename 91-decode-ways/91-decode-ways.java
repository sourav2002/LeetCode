class Solution {    
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        if(arr[0] == '0') return 0;
        return dfs(arr, arr.length-1, dp);
    }
    
    public int dfs(char[] arr, int i, int[] dp){
        if(i <= 0){
            return 1;
        }
        
        if(dp[i] != -1) return dp[i];
        int x = 0;
        int y = 0;
        if(arr[i] != '0'){
           x = dfs(arr, i-1, dp);
        }
        if(arr[i-1] != '0'){
            if(arr[i-1] == '2' && arr[i] > '6' || arr[i-1] > '2'){
                dp[i] = x;
                return x;
            }
            y = dfs(arr, i-2, dp);
        }
        return dp[i] = x+y;
    }
}