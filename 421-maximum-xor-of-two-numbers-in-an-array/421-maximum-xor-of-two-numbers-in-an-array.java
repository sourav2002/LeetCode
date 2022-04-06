class Node{
    Node [] child;
    int cn;
    public Node(){
        child = new Node[2];
        cn = 0;
    }
}

class Trie{
    static Node root;
    
    public Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node cur = root;
        for(int i=30; i>=0; i--){
            int bit = (num >>> i) & 1;
            if(cur.child[bit] == null){
                cur.child[bit] = new Node();
            }
            cur = cur.child[bit];
        }
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie obj = new Trie();
        Node root = new Node();
        for(int num :  nums){
            obj.insert(num);
        }
        
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            Node cur = obj.root;
            int sum = 0;
            for(int i=30; i>=0; i--){
                int bit = (num >>> i) & 1;
                if(cur.child[1-bit] != null){
                    sum += (1 << i);
                    cur = cur.child[1-bit];
                }else{
                    cur = cur.child[bit];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}