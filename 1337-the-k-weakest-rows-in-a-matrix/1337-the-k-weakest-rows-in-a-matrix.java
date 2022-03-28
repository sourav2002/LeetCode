class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int [] res = new int[k];
        int [] count = new int[mat.length]; // store the no. of soldiers 
        
        // iterate into the 2d array and find no. of soldiers for every row 
        for(int i=0; i< mat.length; i++){
            int soldiers = 0;
            for(int j=0; j< mat[0].length; j++){
                if(mat[i][j] == 1) soldiers++;
                else break;
            }
            
    // now store the no. of soldiers in count array
    // we only need index value in final answer so here we will use a trick to find index from soldiers value
            count[i] = soldiers *1000 + i;  // multiply is need to avoid collision of same values
            // for example 0th ind value is 3 and 1th ind value is 2  0--> 3+0,   1--> 2 + 1 (collision)
        }
        
        Arrays.sort(count); // sort values according to no. of soldiers
        
        for(int i=0; i<k; i++) {
            res[i] = count[i] % 1000; // it will return index of that soldier value
        }
        
        return res;
    }
}