public class LFUCache{
    
    HashMap<Integer, Integer> cache = new HashMap<>();
    HashMap<Integer, Integer> keyCounts = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
    int capacity;
    int min = -1;
        
    public LFUCache (int capacity) {
        this.capacity = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(cache.containsKey(key) == false) return -1;
        int count = keyCounts.get(key);
        keyCounts.put(key, count+1); // update
        freqMap.get(count).remove(key);
        if(count == min && freqMap.get(count).size() == 0) min++;
        if(freqMap.containsKey(count+1) == false) freqMap.put(count+1, new LinkedHashSet<>());
        freqMap.get(count+1).add(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
       if(capacity <= 0) return;
       if(cache.containsKey (key)){
            cache.put(key, value);
            get(key);
            return;
        }
        if(cache.size() >= capacity){
            int evict = freqMap.get(min).iterator ().next();
            freqMap.get(min).remove(evict);
            cache.remove (evict);
            keyCounts.remove(evict);
        }
        cache.put(key, value);
        keyCounts.put (key, 1);
        min = 1;
        freqMap.get(1).add(key);
    }
}

/*
class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    // get node value by key, and then update node frequency as well as relocate that node **/
    // public int get(int key) {
    //     DLLNode curNode = cache.get(key);
    //     if (curNode == null) {
    //         return -1;
    //     }
    //     updateNode(curNode);
    //     return curNode.val;
    // }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
//     public void put(int key, int value) {
//         // corner case: check cache capacity initialization
//         if (capacity == 0) {
//             return;
//         }

//         if (cache.containsKey(key)) {
//             DLLNode curNode = cache.get(key);
//             curNode.val = value;
//             updateNode(curNode);
//         }
//         else {
//             curSize++;
//             if (curSize > capacity) {
//                 // get minimum frequency list
//                 DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
//                 cache.remove(minFreqList.tail.prev.key);
//                 minFreqList.removeNode(minFreqList.tail.prev);
//                 curSize--;
//             }
//             // reset min frequency to 1 because of adding new node
//             minFrequency = 1;
//             DLLNode newNode = new DLLNode(key, value);

//             // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
//             DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
//             curList.addNode(newNode);
//             frequencyMap.put(1, curList);
//             cache.put(key, newNode);
//         }
//     }

//     public void updateNode(DLLNode curNode) {
//         int curFreq = curNode.frequency;
//         DoubleLinkedList curList = frequencyMap.get(curFreq);
//         curList.removeNode(curNode);

//         // if current list the the last list which has lowest frequency and current node is the only node in that list
//         // we need to remove the entire list and then increase min frequency value by 1
//         if (curFreq == minFrequency && curList.listSize == 0) {
//             minFrequency++;
//         }

//         curNode.frequency++;
//         // add current node to another list has current frequency + 1,
//         // if we do not have the list with this frequency, initialize it
//         DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
//         newList.addNode(curNode);
//         frequencyMap.put(curNode.frequency, newList);
//     }

//     class DLLNode {
//         int key;
//         int val;
//         int frequency;
//         DLLNode prev;
//         DLLNode next;

//         public DLLNode(int key, int val) {
//             this.key = key;
//             this.val = val;
//             this.frequency = 1;
//         }
//     }

//     class DoubleLinkedList {
//         int listSize;
//         DLLNode head;
//         DLLNode tail;
//         public DoubleLinkedList() {
//             this.listSize = 0;
//             this.head = new DLLNode(0, 0);
//             this.tail = new DLLNode(0, 0);
//             head.next = tail;
//             tail.prev = head;
//         }

//         /** add new node into head of list and increase list size by 1 **/
//         public void addNode(DLLNode curNode) {
//             DLLNode nextNode = head.next;
//             curNode.next = nextNode;
//             curNode.prev = head;
//             head.next = curNode;
//             nextNode.prev = curNode;
//             listSize++;
//         }

//         /** remove input node and decrease list size by 1**/
//         public void removeNode(DLLNode curNode) {
//             DLLNode prevNode = curNode.prev;
//             DLLNode nextNode = curNode.next;
//             prevNode.next = nextNode;
//             nextNode.prev = prevNode;
//             listSize--;
//         }

//     }
// }
// */

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */