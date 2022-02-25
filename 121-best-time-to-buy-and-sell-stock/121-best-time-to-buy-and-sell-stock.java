class Solution {
    public int maxProfit(int[] arr) {
         int n = arr.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            if (arr[i] < minPrice){
                minPrice = arr[i];
            }else if (arr[i] - minPrice > maxProfit){
                maxProfit = arr[i] - minPrice;
            }
        }
        return maxProfit;
    }
}