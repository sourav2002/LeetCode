class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        int[][] board = new int[n][n];
        dfs(0, board, n, count);
        return count[0];
    }
    
    public void dfs(int col, int[][] board, int n, int[] count){
        if(col == n){
            // System.out.println("yess");
            count[0]++;
            // System.out.println(count[0]);
            return;
        }
        
        for(int row = 0; row <n; row++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 1;
                dfs(col+1, board, n, count);
                board[row][col] = 0;
            }
        }
    }
    
    public boolean isSafe(int row, int col, int[][] board, int n){
        int originalRow = row;
        int originalCol = col;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == 1) return false;
            row--;
            col--;
        }
        
        row = originalRow;
        col = originalCol;
        while(col >= 0){
            if(board[row][col] == 1) return false;
            col--;
        }
        row = originalRow;
        col = originalCol;
        while(row < n && col >= 0){
            if(board[row][col] == 1) return false;
            row++;
            col--;
        }
        return true;
    }
    
}