class Solution {
    public int[] countBits(int n) {
        // int[] arr = new int[n+1];
        // for(int i=0; i<=n; i++){
        //     arr[i] = count(i);
        // }
        // return arr;.
        int[] f = new int[n + 1];
        for (int i=1; i<=n; i++) {
            f[i] = f[i >> 1] + (i & 1); // if i =8 ..f[8>>1] = f[4] = f[2]
        }
        return f;
    }
    // static int count(int i){
    //     int count =0;
    //     while(i != 0){
    //         count += i &1; 
    //         i = i>>1;
    //     }
    //     return count;
    // }
}