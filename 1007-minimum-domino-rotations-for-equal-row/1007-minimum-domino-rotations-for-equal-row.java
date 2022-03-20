class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        // if it is possible to make all elements of array to be same then their 1st element should be the same
        // suppose if our target value is 2 but 1st element in either array is not 2 then it is not possible
        int swapTop = convertionToTarget(tops, bottoms, tops[0]);
        int swapBottom = convertionToTarget(tops, bottoms, bottoms[0]);
        
        if(swapTop > 0 && swapBottom > 0){
            return Math.min(swapTop, swapBottom);
        }else if(swapTop > 0){
            return swapTop;
        }else return swapBottom;
    }
    
    public int convertionToTarget(int[] t, int[] b, int target){
        int ct = 0;  // count top
        int bt = 0;  // count bottom
        
        for(int i=0; i< t.length; i++){
            if(t[i] != target && b[i] != target){
                return -1;
            }
            
            if(t[i] != target && b[i] == target){
                ct++;
            }
            if(t[i] == target && b[i] != target){
                bt++;
            }            
        }
        
        return Math.min(ct, bt);
    }
}