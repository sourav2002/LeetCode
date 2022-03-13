class Solution {
    public boolean isValid(String s) {
        Stack<Character> st  = new Stack();
        
        for(char ch : s.toCharArray()){
            if(ch == '[' || ch == '(' || ch=='{'){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    char c = st.pop();
                    if(ch==']' && c == '[' || ch=='}' && c=='{' || ch==')' && c=='('){
                        continue;
                    }else{
                        return false;
                    }
                    
                }else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
        
        
    }
}