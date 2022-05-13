class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        String str = "";
        solve(n,n, list, str);
        return list;
    }
    
    public void solve(int open, int close, List<String> list, String str){
        if(open == 0 && close == 0){
            list.add(str);
            return;
        }
        
        if(open != 0){
            String st1 = str;
            st1 += "(";
            solve(open-1, close, list, st1);
        }
        if(close > open ){
            String st2 = str;
            st2 += ")";
            solve(open, close-1, list, st2);
        }
        return;
    }
}