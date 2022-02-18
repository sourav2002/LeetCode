class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0)  return num;
        if(k == len) return "0"; // if num length is x and we have to remove x elements
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        
        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop(); // if current element is smaller then prev element
                k--;
            }
            // push every element in stack
            stack.push(num.charAt(index++));
        }
        
        // if there is no character which is lesser then its previous index value then pop k elements
        while(k-- > 0) stack.pop();
        
        String smallest = "";
        while(!stack.isEmpty()) smallest = stack.pop() + smallest;
        
		// delete leading zeros
        while(smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);
        
        return smallest;
    }
}