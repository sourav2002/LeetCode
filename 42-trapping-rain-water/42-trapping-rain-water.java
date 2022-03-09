class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int[] water = new int[n];
        
        int max = 0;
        for(int l=0; l< n; l++){
            max = Math.max(max, arr[l]);
            maxL[l] = max;
        }
        
        max = 0;
        for(int r = n-1; r>=0; r--){
            max = Math.max(max, arr[r]);
            maxR[r] = max;
        }
        
        for(int w =0; w<n; w++){
            int wtr = Math.min(maxL[w], maxR[w]) - arr[w];
            water[w] = wtr;
        }
        
        int ans = 0;
        for(int i : water){
            ans += i;
        }
        
        return ans;
    }
}