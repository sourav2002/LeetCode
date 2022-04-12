class MinStack {
	private Node head;
        
    public void push(int x) {
        if (head == null) {
            Node node = new Node(x, x);
            node.next = head;
            head = node;
        }
            
        else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
            
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
        
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}