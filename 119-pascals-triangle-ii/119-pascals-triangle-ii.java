class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList();
        List<Integer> previous = null; 
        // row defines the current list and previous defines the previous list
        
        for (int i = 0; i <= rowIndex; i++) {
            row = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { 
                    // make 1st and last value of list/ row equals to One 1
                    row.add(1);
                } else { // else add two values j-1 and j of previous list/row
                    row.add(previous.get(j - 1) + previous.get(j));
                }
            }
            previous = row; // save the current row as previous for calculation of next row
        } 
        return row;
    }
}