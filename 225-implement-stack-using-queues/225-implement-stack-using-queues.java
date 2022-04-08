class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();
    }

    public void push(int x) {
        
        q.add(x);
        int size = q.size();
        for(int i = 1; i< size; i++){
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
