
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i< n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList();
        dfs(0, board, ans,n);
        return ans;
    }
    
    public void dfs(int col , char[][] board, List<List<String>> ans, int n){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        
        for(int row =0; row < n; row++){
            if(safe(row, col, board, n) ){
                board[row][col] = 'Q';
                dfs(col+1, board, ans,n); // recursion 
                board[row][col] = '.'; // backtrack (if a dfs call not able to put a Q in entire row)
            }
        }
    }
    /*
    
                           (row--, col--)                        <-\
                                         \                          \
                                          \                          \                
                           (row, col--) -- (row, col)          <------ check if queen is not attacking
                                           /                         /               
                                          /                         /    
                           (row++, col--)                        <-/     
    */

    public boolean safe(int row, int col, char[][] board, int n){
        for(int i= row, j = col; i>= 0 && j >= 0; i--, j-- ){
            if(board[i][j] == 'Q') return false;
        }
        for(int i= row, j = col; i>= 0 && j >= 0; j-- ){
            if(board[i][j] == 'Q') return false;
        }
        for(int i= row, j = col; i<n && j >= 0; i++, j-- ){
            if(board[i][j] == 'Q') return false;
        }
        
        return true;
    }
        
    // convert 2D array to list
    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList();
        for(int i=0; i< board.length; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}


    
    /*
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList();
        // creating chess board
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        int[] firstHash = new int[2 * n - 1];
        int[] rowHash = new int[n];
        int[] thirdHash = new int[2 * n - 1];

        backtrack(0, chessBoard, ans, n, firstHash, rowHash, thirdHash);
        return ans;
    }

    public void backtrack(int col, char[][] chessBoard, List<List<String>> ans, int n, int[] firstHash, int[] rowHash, int[] thirdHash) {
        if (col == n) {
            ans.add(construct(chessBoard));
            return;
        }

        // traverse in every col
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, n, firstHash, rowHash, thirdHash)) {
                chessBoard[row][col] = 'Q';
                firstHash[n - 1 + row - col] = 1;
                rowHash[row] = 1;
                thirdHash[col + row] = 1;
                backtrack(col + 1, chessBoard, ans, n, firstHash, rowHash, thirdHash);
                chessBoard[row][col] = '.'; // backtrack
                firstHash[n - 1 + row - col] = 0;
                rowHash[row] = 0;
                thirdHash[row + col] = 0;
            }
        }
    }

    public boolean isSafe(int row, int col, int n, int[] firstHash, int[] rowHash, int[] thirdHash) {
        if (rowHash[row] == 1 || thirdHash[row + col] == 1 || firstHash[n - 1 + row - col] == 1) return false;
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> ans = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}
*/
