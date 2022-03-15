class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c  = s.charAt(i);
            if(c == '('  ){
                st.push(i);
            }else if(c==')'){
                if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!st.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}