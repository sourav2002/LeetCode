class MyLinkedList {
    Node head;
    int size;
    
    class Node{
        Node next;
        int data;
        public Node(int d){
            data = d;
            next = null;
        }
    }
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        
        Node cur = head;
        for(int i=0 ; i< index; i++){
            cur = cur.next;
        }
        return cur.data;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node cur = head;
        if(head == null){
            addAtHead(val);
            return;
        }
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        Node cur = head;
        if(index < 0 || index > size) return; //invalid index
        if(index == 0){
            addAtHead(val);
            return;
        }
        for(int i=0; i< index-1; i++){
            cur = cur.next;
        }
        if(cur.next == null){
            cur.next = node;
            size++;
            return;
        }
        
        node.next = cur.next;
        cur.next  = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node cur = head;
        if(index == 0){
            head = head.next;
            size--;
            return;
        }
        for(int i=0; i<index-1; i++){
            cur=cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */