class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        int end = s.length()-1;
        int st = 0;
        while(st <= end){
            if(s.charAt(st) != s.charAt(end)){
                return 2;
            }
            st++;
            end--;
        }
        return 1;
    }
}