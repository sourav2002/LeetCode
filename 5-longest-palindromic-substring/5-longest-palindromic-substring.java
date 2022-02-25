class Solution {
    public String longestPalindrome(String s) {
        if(s != null && s.length() <= 1) 
            return s;
        
        int len =0, start = 0, end =0, len1 =0, len2 =0; 
        
        for(int i =0; i<s.length(); i++){
            len1 = expandAroundCenter(s, i, i);  //  babad  -> bab // for odd length ans
            len2 = expandAroundCenter(s, i, i+1);// cbbd -> bb // for even length ans
            
            len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2; // bcz array is 0 index based
                end = i + len/2;//  bcz end index is gonna be greater then center(i)
            }
        }
        
        return s.substring(start, end+1); // 1st index in included and last is excluded
    }
    
    public int expandAroundCenter(String s, int i, int j){
        while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        
        // while loop is terminated bcz now char at i and j is not same so we are one step ahead
        return j - i - 1;
    }
}