// class Solution {

//     //Recursive
//     public int minimumTotal(List<List<Integer>> triangle) {
//         if (triangle == null || triangle.size() == 0) return 0;

//         return dfs(0, 0, triangle);
//     }

//     public int dfs(int row, int pos, List<List<Integer>> triangle) {
//         //Out of bounds so just return sum previous value must be leaf node
//         if (row + 1 >= triangle.size()) return triangle.get(row).get(pos);

//         return triangle.get(row).get(pos) + Math.min(dfs(row + 1, pos, triangle), dfs(row + 1, pos + 1, triangle));
//     }
// }

// //Top down
// class Solution {

//     public int minimumTotal(List<List<Integer>> triangle) {
//         if (triangle == null || triangle.size() == 0) return 0;
//         Integer[][] cache = new Integer[triangle.size()][triangle.size()];
//         return dfs(0, 0, triangle, cache);
//     }

//     int dfs(int row, int pos, List<List<Integer>> triangle, Integer[][] cache) {
//         //Out of bounds so just return sum previous value must be leaf node
//         if (row + 1 >= triangle.size()) {
//             return triangle.get(row).get(pos);
//         }
//         if (cache[row][pos] != null) return cache[row][pos];
//         cache[row][pos] = triangle.get(row).get(pos) + Math.min(dfs(row + 1, pos, triangle, cache), dfs(row + 1, pos + 1, triangle, cache));
//         return cache[row][pos];
//     }
// }

// //Bottom up
// class Solution {

//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][] dp = new int[triangle.size()][triangle.size()];
//         //Remember base case is just returning leaf nodes
//         for (int i = 0; i < triangle.size(); i++) {
//             dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
//         }
//         for (int row = triangle.size() - 2; row >= 0; row--) {
//             for (int pos = 0; pos < triangle.get(row).size(); pos++) {
//                 dp[row][pos] = triangle.get(row).get(pos) + Math.min(dp[row + 1][pos + 1], dp[row + 1][pos]);
//             }
//         }
//         return dp[0][0];
//     }
// }


//Bottom up O(n) space complexity.

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int[] dp1 = new int[triangle.size()];
        //Remember base case is just returning leaf nodes
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int pos = 0; pos < triangle.get(row).size(); pos++) {
                dp1[pos] = triangle.get(row).get(pos) + Math.min(dp[pos + 1], dp[pos]);
            }
            dp = dp1;
        }
        return dp[0];
    }
}


/*
we are having 2  choices. Either choose the value at index (i,j) or the value at index(i,j+1)
in recursion, it is possible that for one of the recursive call is on the same track which is previously solved by one the the recursion calls.
So for that repetitive calculation, use dp memoization.
*/
