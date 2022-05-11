class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n, k);
    }
    
    public int solve(int n, int k){
        if( n == 1 && k == 1){
            return 0;
        }
        
        int mid = ((int)(Math.pow(2, n-1)) / 2);
        if(k <= mid){
            return solve(n-1, k);
        }else{
            return solve(n-1, k-mid) == 0? 1 : 0;
        }
    }
}