class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        Queue<int[]> q = new LinkedList();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] point = q.poll();
                if (point[0] == m - 1 && point[1] == n - 1) {
                    return ans + 1;
                }
                for (int[] d : dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        q.add(new int[] { r, c });
                        grid[r][c] = 1;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
