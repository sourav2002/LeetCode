class Solution {
    public int titleToNumber(String str) {
        int len = str.length();
        int sum = 0;
        for(int i = 0; i < len; i++){
           sum += ((int)str.charAt(len-i-1) - 64) * Math.pow(26, i);
        }
        return sum;
    }
}