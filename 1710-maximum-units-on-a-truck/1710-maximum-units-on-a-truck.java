class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {
        Arrays.sort(arr, (a,b) ->{
            return b[1] - a[1];
        });
        int c = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i][0] <= truckSize){
                c += arr[i][0] * arr[i][1];
                truckSize -= arr[i][0];
            }else{
                c += truckSize * arr[i][1];
                truckSize = 0;
            }
            
            if(truckSize == 0) break;
        }
        
        return c;
    }
}