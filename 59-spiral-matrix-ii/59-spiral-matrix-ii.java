class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
        
        int val = 1;
        while(r1<= r2 && c1<=c2){
            
            // move left to right
            for(int c = c1; c<=c2; c++) arr[r1][c] = val++;
            
            // move down
            for(int r = r1+1; r<=r2; r++) arr[r][c2] = val++;
            
            // check if we have enough row or col to move (assume row == col then no move)
            if( r1< r2 && c1 < c2){
                
                // move right to left
                for(int c = c2-1; c>= c1; c--) arr[r2][c] = val++;
                
                // move up
                for(int r= r2-1; r > r1; r--) arr[r][c1] = val++;
            }
            
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return arr;
    }
}