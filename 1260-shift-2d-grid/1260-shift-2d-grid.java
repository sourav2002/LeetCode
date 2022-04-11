class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int temp = -1;
        List<List<Integer>> list = new ArrayList();
        int i =-1;
        int n = grid.length;
        int m = grid[0].length;
        
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
        
        ArrayList<Integer> helper = new ArrayList();
        int rm = k;
        while(rm-->0){
            helper.add(row.remove(row.size()-1));
        }
        while(helper.size() > 0){
            row.add(0, helper.remove(0));
        }
        
        List<Integer> fin = new ArrayList();
        for(int j = 0; j< row.size(); j++){
            if(j % m == 0){
                if(j != 0) list.add(fin);
                fin = new ArrayList();
            }
            fin.add(row.get(j));
        }
        list.add(fin);
        return list;
    }
}