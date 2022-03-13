class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean [][] arr = new boolean[n][n];
        
        for(int [] digged : dig){
            arr[digged[0]][digged[1]] = true;
        }
        
        int count = 0;
        
        for(int artifact[] : artifacts){
            boolean canBeExtracted = true;
            
            for(int i =artifact[0]; i<=artifact[2]; i++){
                for(int j = artifact[1]; j<= artifact[3]; j++){
                    if(!arr[i][j]){
                        canBeExtracted = false;
                        break;
                    }
                }
            }
            
            if(canBeExtracted) count++;
        }
        return count;
    }
}

/*
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<String> set = new HashSet<>();
        for (int d[] : dig) set.add(d[0] + " " + d[1]);
        int c = 0;
        for (int a[] : artifacts) {
            boolean done = true;
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    if (!set.contains(i + " " + j)) done = false;
                }
            }
            if (done) c++;
        }
        return c;
    }
}
//TC = O(DIG + N^2)
*/