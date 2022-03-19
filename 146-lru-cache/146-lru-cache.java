// notes :   [head] -> node1 -> node2 -> node3 -> [tail]
// where head.next is mru (most recently used) and tail.prev is lru (least recently used)

class LRUCache {
    Node head = new Node(0,0), tail = new Node(0,0); // initialized double linkedlist, head -> tail &&   head <- tail
    Map<Integer, Node> map = new HashMap();  // hashmap to get the node directly by value
    int capacity = 0;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    
    // check if we have this node or note
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    
    
    public void put(int key, int value) {
        if(map.containsKey(key)){// before inserting check if we have this key, if yes then remove it
            remove(map.get(key));
        }
        if(map.size() == capacity){ // if we dont have this key but our capacity is full then remove tail.prev
            remove(tail.prev);
        }
        
        insert(new Node(key , value));
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }
    
    
    // node class for doubly linked list
    static class Node {
        Node next, prev;
        int key, value;
        Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */