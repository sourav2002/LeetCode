class Solution {
    public boolean searchMatrix(int[][] a, int target) {
//         if(a.length == 0) return false;
//         int i = 0;
//         int j = a[0].length-1;
        
//         while( j>=0 && i < a.length){
            
//             if(target == a[i][j]){
//                 return true;
//             }
//             if(target < a[i][j]){
//                 j--;
//             }else if(target > a[i][j]){
//                 i++;
//             }
//         }
//         return false;
        
        // more optimized solution
                    if (a == null || a.length == 0) {
                return false;
            }
            int start = 0, rows = a.length, cols = a[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = start+(end - start) / 2;
                if (a[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (a[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
    }
}