class Solution {
    public int maxScore(int[] arr, int k) {
        int maxi = Integer.MIN_VALUE;
        int winsum = 0;
        int total = 0;
        for(int i=0; i<arr.length; i++){
            total += arr[i];
            if(i == arr.length-k-1){
                winsum = total;
            }
        }
        maxi = Math.max(maxi, total - winsum);
        if(k == arr.length){
            return total;
        }
        
        // winsum = 10; 364 - 162 - 162 - 283 - 204
        // total = 22;
        for(int i=1; i<= k; i++){
            winsum -= arr[i-1];
            winsum += arr[i+arr.length-k-1];
            maxi = Math.max(maxi, total-winsum);
        }
        return maxi;
    }
}