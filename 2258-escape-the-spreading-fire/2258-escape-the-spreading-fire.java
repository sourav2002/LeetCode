class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> fires = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fires.add(new int[] { i, j });
                }
            }
        }
        
        int l = -1, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (reachable(grid, mid, fires)) l = mid; else r = mid - 1;
        }
        return l == m * n ? (int) 1000000000 : l;
    }

    public boolean reachable(int[][] grid, int move, List<int[]> fires) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = copy(grid);

        Queue<int[]> fire = new LinkedList<>();
        fire.addAll(fires);
        while (!fire.isEmpty() && move-- > 0) {
            spread(fire, copy, false);
        }

        Queue<int[]> person = new LinkedList<>();
        person.add(new int[] { 0, 0 });
        while (!person.isEmpty()) {
            spread(fire, copy, false);
            if (spread(person, copy, true)) return true;
            if (copy[m - 1][n - 1] != 0) return false;
        }
        return false;
    }

    public int[][] copy(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    public boolean spread(Queue<int[]> queue, int[][] grid, boolean shouldReturn) {
        int m = grid.length, n = grid[0].length;
        int size = queue.size();
        while (size-- > 0) {
            int[] cell = queue.remove();
            for (int[] d : directions) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                if (shouldReturn && x == m - 1 && y == n - 1) return true;
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = -1;
                    queue.add(new int[] { x, y });
                }
            }
        }
        return false;
    }
}