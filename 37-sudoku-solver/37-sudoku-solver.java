class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        // solve(board,0,0);
    }
    
   
    boolean solve(char[][] board){
        for(int i=0; i< 9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <='9'; c++){
                        if(isValid(board,i, j, c)){
                            board[i][j] = c;
                            if(solve(board) == true) return true; // recursion 
                            else board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // if you are not able to put any number[0-9] at any empty position
                }
            }
        }
        return true; // loop runs successfully. (means we have filled all empty indexes)
    }
    
    public boolean solve(char[][] board, int i, int j) {
        // if(i == 9 && j == 0) return true;
        // if(board[i][j] != '.') return solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1);
        if(i==9) return true;
        if(j==9) return solve(board, i+1, 0);
        if(board[i][j] != '.') return solve(board, i, j+1);
        
        for(char c = '1'; c <= '9'; c++) {
            if(isValid(board, i, j, c)){
                board[i][j] = c;
                // if(solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1)) return true;
                if(solve(board, i, j+1)) return true;// recursion call 
                board[i][j] = '.'; // backtrack
            }
        }
        
        return false;
        
    }
    
    boolean isValid(char[][] board, int i, int j, char val){
        int row = i - i%3, column = j - j%3;
        for(int x=0; x<9; x++) if(board[x][j] == val) return false;
        for(int y=0; y<9; y++) if(board[i][y] == val) return false;
        for(int x=0; x<3; x++)
            for(int y=0; y<3; y++)
                if(board[row+x][column+y] == val) return false;
        return true;
    }
}