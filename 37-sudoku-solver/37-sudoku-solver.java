class Solution {
    public void solveSudoku(char[][] board) {
        // solve(board);
        solve(board,0,0);
    }
    
   /*
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
    */
    public boolean solve(char[][] board, int i, int j) {
        if(i == 9 && j == 0) return true;
        // if board[i][j] already has a value then skip 
        if(board[i][j] != '.') return solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1);
        
        for(char num = '1'; num <= '9'; num++) {
            if(isValid(board, i, j, num)){
                board[i][j] = num;
                if(solve(board, (j+1) == 9? i+1 : i, (j+1) == 9? 0 : j+1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
        
    }
    
    boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i< 9; i++){
            if(board[i][col] == c) return false;
            
            if(board[row][i] == c) return false;
            
            if(board[3* (row/3)+ i/ 3] [3 * (col/3) + i%3] == c) return false;            
        }
        return true;
    }
}