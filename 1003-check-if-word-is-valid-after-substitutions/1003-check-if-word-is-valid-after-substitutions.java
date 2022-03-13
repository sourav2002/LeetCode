class Solution {
        public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
    /*
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch=='a' || ch =='b'){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    char second = st.pop();
                    if(st.isEmpty())return false;
                    char first = st.pop();
                    if(second != 'b' || first != 'a') return false;
                }else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
    */
}