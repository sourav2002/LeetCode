class Solution {
    public int maximumCandies(int[] c, long k) {
        
        long max = 0;
        for(int i: c){
            max += i;
        }
        if(k > max) return 0;
        
        long low = 1;
        long high = max/k;
        long res = -1;
        
        while(low <= high){
            long mid = low+high >>>1;            
            if(isPossible(mid, c, k)){
                res = mid;
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return (int)res;
    }
    
    public boolean isPossible(long mid, int[] arr, long k){
        
        long split = 0;
        for(int i=0; i< arr.length; i++){
            split += arr[i]/ mid;
        }
        
        return split >= k; 
    }
}