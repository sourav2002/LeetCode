class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
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
    
    boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i< 9; i++){
            if(board[i][col] == c) return false;
            
            if(board[row][i] == c) return false;
            
            if(board[3* (row/3)+ i/ 3] [3 * (col/3) + i%3] == c) return false;            
        }
        return true;
    }
}