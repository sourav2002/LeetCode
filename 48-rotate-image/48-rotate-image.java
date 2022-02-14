class Solution {
    public void rotate(int[][] matrix) {
         // transpose the matrix
        for(int i=0; i< matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // transpose of the matrix means swapping 1st row with 1st column upto nth row with nth column
        /*
        1 2 3       1 4 7
        4 5 6  -->  2 5 8
        7 8 9       3 6 9 
        
        now simply reverse every row
        and we get the desired matrix
        
        */
        // reverse every row
        // 2 pointer method
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}