class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)- 'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i< s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(seen[c]) continue;
            while(!st.isEmpty() && st.peek() > c && i-1 < lastIndex[st.peek()]){
                 seen[st.pop()] = false;
            }  
            st.push(c);
            seen[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char) (st.pop()+'a'));
        }
        return sb.reverse().toString();
    }
}

/*
take a stack to let char in and out according to our requirment
take a "lastIndex" array to store the last index of every char
take a boolean array "seen", whenever we put a char in stack mark it seen

    1) take a stack, and put the 1st char of string in stack and also mark that char as seen
    2) for next char, if char is already seen before then skip further steps. else follow further steps.
    2) for next char, if current char is smaller then char at top of the stack(st.peek()), then remove char at top
    from the stack(only if char at top of stack is not last occurence of that char ) and also make that char as             unseen(false)
    3) put the current char in our stack only if it is unseen (if seen[ch] == true) then continue; and mark it seen
    4) pop the stack values and append in stringbuilder, and return reverse of stringBuilder
*/