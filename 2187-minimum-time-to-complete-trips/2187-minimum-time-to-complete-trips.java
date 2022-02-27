class Solution {
    public long minimumTime(int[] time, int t) {
        
     long l =0, r =100000000000000L, ans = r;
        while(l < r){
            long mid = l +(r-l)/2;
            long ct = 0;
            for(int i=0; i<time.length; i++){
                ct += mid / time[i];
            }
            if(ct >= t){
                r = mid;
                ans = Math.min(ans, mid);
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}