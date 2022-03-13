class Solution {
    public int maximumTop(int[] arr, int k) {
        int n = arr.length;
        
        if(n == 1 && k%2 == 1) return -1;
        if(n == 1 && k%2 == 0) return arr[0];
        int ans = 0;
        if(k > n){
            for(int i : arr) ans = Math.max(ans, i);
            return ans;
        }
        
        else if(k == n){
            for(int i =0; i< k-1; i++) ans = Math.max(ans, arr[i]); 
            return ans;
        }
        else if(k < n){
            for(int i =0; i< k-1; i++) ans = Math.max(ans, arr[i]); 
            return Math.max(ans, arr[k]);
        }
        return ans;
    }
}