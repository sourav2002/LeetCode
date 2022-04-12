class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        
        // put the position of all rotten oranges in queue
        // count the number of fresh oranges + initial rotten oranges also
        // rotten also so that we can easily compare queue.size..(cnt) and count_fresh
        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] != 0){
                    count_fresh++;
                }
            }
        }
        
        // if there is no fresh orange in the starting
        if(count_fresh == 0) return 0; 
        
        int days =0, cnt = 0;
        // all 4 directions to check other oranges around a rotten orange
        int dx[] = { 0, 0, 1,-1 };
        int dy[] = { 1,-1, 0, 0 };
        
        // get all initial rotten oranges from queue ds
        while(!q.isEmpty()){
            int size = q.size();
            cnt += size; // add count of rotten oranges
            
            for(int a=0; a<size; a++){
                int[] curOrange = q.poll();
                // travell all 4 directions around curOrange
                for(int i=0; i<4;i++){
                    int x = curOrange[0] + dx[i];
                    int y = curOrange[1] + dy[i]; 
                    
                    // if new xy co-ordinate has any fresh orange then make it rotten
                    if( x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0 || grid[x][y] == 2 ){
                        continue;
                    }
                    //else
                    grid[x][y] = 2;
                    //also put new rotten orange position in queue
                    q.offer(new int[]{x,y});
                }
            }
            // means some fresh oranges just got rotted so it take one day/minute to do so
            if(q.size() != 0){
                days++;
            }
        }
        
        if(cnt == count_fresh){
            return days;
        }else{
            return -1;
        }
        
    }
}