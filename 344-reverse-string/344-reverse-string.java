class Solution {
    public void reverseString(char[] s) {
        
        solve(s, 0);
    }
    
    public void solve(char[] s, int ind){
        if(ind == s.length/2){
            return;
        }
        
        swap(s, ind , s.length-ind-1);
        solve(s,ind+1);
    }
    
    public void swap(char[] s, int i, int j ){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}