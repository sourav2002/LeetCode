class Solution {

    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = 1_000_000;
        int m = heights.length, n = heights[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            boolean[][] visited = new boolean[m][n];
            if (minimumEffortDFS(heights, mid, 0, 0, m, n, dirs, visited)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    // O(m*n)
    public boolean minimumEffortDFS(int[][] heights, int mid, int x, int y, int m, int n, int[][] dirs, boolean[][] visited) {
        if (x == m - 1 && y == n - 1) return true;

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int row = x + dir[0];
            int col = y + dir[1];

            if (row == -1 || col == -1 || row == m || col == n || visited[row][col] || Math.abs(heights[x][y] - heights[row][col]) > mid) continue;

            if (minimumEffortDFS(heights, mid, row, col, m, n, dirs, visited)) return true;
        }
        return false;
    }
}
/*
class Solution {
    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 10000000;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(isPossible(heights, m))
                r = m;
            else
                l = m + 1;
        }
        
        return l;
    }
    
    private Boolean isPossible(int[][] h, int mid) {
        int r = h.length, c = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        while(q.size() != 0) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            if(x == r - 1 && y == c - 1) return true;
            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && Math.abs(h[x][y] - h[nx][ny]) <= mid) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}
*/
