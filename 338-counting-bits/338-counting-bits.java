class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = count(i);
        }
        return arr;
    }
    static int count(int i){
        int count =0;
        while(i != 0){
            count += i &1; 
            i = i>>1;
        }
        return count;
    }
}