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
            if( safe(row, col, board, n) ){
                board[row][col] = 'Q';
                dfs(col+1, board, ans,n);
                board[row][col] = '.'; // backtrack
            }
        }
    }
    
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
    
    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList();
        for(int i=0; i< board.length; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}