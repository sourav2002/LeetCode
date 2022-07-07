class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        int m = s1.length();
        int n = s2.length();
        if(m+n != arr3.length) return false;
        return dfs(arr1, arr2, arr3, 0, 0, 0, new boolean[m+1][n+1]);
    }
    
    
    public boolean dfs(char[] s1, char[] s2, char[] s3, int i, int j, int k, boolean[][] invalid){
        if(invalid[i][j]) return false;
        if(k == s3.length){
            return true;
        }
        
        boolean valid = i < s1.length && s1[i] == s3[k] && dfs(s1, s2, s3, i+1, j, k+1, invalid) ||
            j < s2.length && s2[j] == s3[k] && dfs(s1, s2, s3, i, j+1, k+1, invalid);
        
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}
