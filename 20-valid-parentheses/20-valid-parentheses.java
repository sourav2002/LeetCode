class Solution{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
    
/*
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
*/