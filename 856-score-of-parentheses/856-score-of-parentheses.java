class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length(), d = 0, R = 0;
        
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            // if `(` increase the depth
            if(ch == '(')
                d++;
            else {
            // if `)` decrease the depth
                --d;
                // check if a balanced pair is getting formed, if yes update the result
                if(s.charAt(i-1) == '(')
                    R += Math.pow(2, d);
            }
        }
        return R;
    }
}
