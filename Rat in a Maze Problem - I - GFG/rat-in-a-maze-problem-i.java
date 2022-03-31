// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        int[][] vis = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        if(arr[0][0] == 1 ) solve(0, 0, arr, n, ans, "", vis);
        return ans;
    }
    
    public static void solve(int i, int j, int[][]arr,int n, ArrayList<String> ans, String s, int[][] vis){
        
        if( i >= n || j >= n) return;
        if( i < 0 || j < 0 || vis[i][j] == 1) return;
        if(arr[i][j] == 0) return;
        if(i == n-1 && j == n-1){
            ans.add(s);
            return;
        }
        
            vis[i][j] = 1;
            
            
            s+="D";
            solve(i+1, j, arr,n,ans,s, vis);
            s =s.substring(0, s.length()-1);
            
            s += "L";
            solve(i, j-1, arr,n,ans,s, vis);
            s =s.substring(0, s.length()-1);
            
            s += "R";
            solve(i, j+1, arr,n,ans,s, vis);
            s = s.substring(0, s.length()-1);
            
            s+="U";
            solve(i-1, j, arr,n,ans,s, vis);
            s = s.substring(0, s.length()-1);
            
            vis[i][j] = 0; // backtrack
    }
}