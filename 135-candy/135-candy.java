class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int c[] = new int[n];
        
        Arrays.fill(c,1);
        
        // from left
        for(int i =1;i< n;i++){
            if(arr[i] > arr[i-1]){
                c[i] = Math.max(c[i], c[i-1]+1);
            }
        }
        
        // from right
        for(int i=n-2; i>=0;i--){
            if(arr[i] > arr[i+1]){
                c[i] = Math.max(c[i], c[i+1]+1);
            }
        }
        int sum = 0;
        for(int i : c){
            sum += i;
        }
        
        return sum;
    }
}