class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int dp = 0;
        //   this dp array stores the total points when taking i cards from left.
        //   since we could take 0 - k cards from left ,the length of the dp array would be k+1.

        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
            dp += cardPoints[i];
        }
        int max_points = dp;

        for (int i = 1; i < k + 1; i++) {
            dp = dp + cardPoints[i - 1] - cardPoints[cardPoints.length - k + i - 1];
            max_points = Math.max(max_points, dp);
        }

        return max_points;
    }
}

/*
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
*/