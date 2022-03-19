class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap();
        freqStack = new HashMap();
        maxFreq = -9999;
    }
    
    // 3 steps - 
    // 1. increment freq of val in freqMap
    // 2. update the maxFreq 
    // 3. add value in freq stack having key as freq of val
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, freq);
        if(freq > maxFreq){
            maxFreq = freq;
        }
        freqStack.computeIfAbsent(freq, f -> new Stack() ).push(val);
    }
    
    
    // 3 steps - 
    // 1. return and remove the top of maxFreq
    // 2. update maxFreq(decrement by 1 if stack get empty)
    // 3. update freqMap
    public int pop() {
        Stack<Integer> st = freqStack.get(maxFreq);
        int top = st.pop();
        if(st.isEmpty()){
            maxFreq--;
        }
        freqMap.put(top, freqMap.get(top)-1);
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */