class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> list = new ArrayList(); // final list
        int i =-1;
        int n = grid.length;
        int m = grid[0].length;
        
        // n*m is total no. of elements, let suppose n=3, m=3, total = 9
        // if k is also 9 then no need to change the grid
        k = k % (n*m);
        
        List<Integer> row = new ArrayList();
        for(int j = 0; j<(n*m); j++){
            if( j % m == 0){
                i++;
            }
            row.add(grid[i][j%m]);
        }
        
        // base case ---- if [[1]] 
        if(row.size() == 1){
            list.add(row);
            return list;
        }
        
        // remove k elements from the last of  row list and add them in helper list
        ArrayList<Integer> helper = new ArrayList();
        int rm = k;
        while(rm-->0){
            helper.add(row.remove(row.size()-1));
        }
        
        // now remove all elements from helper and add in front of row list
        while(helper.size() > 0){
            row.add(0, helper.remove(0));
        }
        
        
        // find length of horizonally elements (length of any row)
        // add that amout of element in temp then add temp in final list
        // every time we hit j % m (where m is the horizontal length) reinitialized temp
        List<Integer> temp = new ArrayList();
        for(int j = 0; j< row.size(); j++){
            if(j % m == 0){
                if(j != 0) list.add(temp);
                temp = new ArrayList();
            }
            temp.add(row.get(j));
        }
        list.add(temp);
        return list;
    }
}