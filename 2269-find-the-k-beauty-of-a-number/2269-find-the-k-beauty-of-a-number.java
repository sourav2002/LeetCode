class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int n = str.length();
        if(n == k) return 1;
        int c =0;
        int i=0;
        while(i <= n-k){
            String s = str.substring(i, i+k);
            if(Integer.valueOf(s) == 0){
                i++;
                continue;
            }
            if(Integer.valueOf(str) % Integer.valueOf(s) == 0){
                c++;
            }
            i++;
        }
        return c;
    }
}