class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0},{-1,0}};
        boolean visited[][][] = new boolean[m][n][k+1];
        int step = 0;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0,k});
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                // if curr is the destination, return steps;
                if(curr[0] == m-1 && curr[1] == n-1) return step;
                // else go in all valid directions
                for(int[] d : dir){
                    int i = curr[0]+d[0];
                    int j = curr[1]+d[1];
                    int obstacle = curr[2];
                    
                    // traverse through valid cells
                    if(i>=0 && j>= 0 && i< m && j < n){
                        // if the cell is empty, visite the cell and add in queue
                        if(grid[i][j] == 0 && !visited[i][j][obstacle]){
                            q.offer(new int[]{i,j,obstacle});
                            visited[i][j][obstacle] = true;
                        }
                        else if(grid[i][j] == 1 && obstacle > 0 && !visited[i][j][obstacle-1]){
                            obstacle -= 1;
                            q.offer(new int[]{i,j,obstacle});
                            visited[i][j][obstacle] = true;
                        }
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}