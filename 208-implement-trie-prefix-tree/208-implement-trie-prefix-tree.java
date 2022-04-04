class TrieNode{
    TrieNode[] child;
    boolean isWord;
    public TrieNode(){
        this.child = new TrieNode[26];
        this.isWord = false;
    }
}
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c -'a';
            if(cur.child[index] == null){
                TrieNode node = new TrieNode();
                cur.child[index] = node;
                cur = node;
            }else{
                cur = cur.child[index];
            }
        }
        cur.isWord = true;
        
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.child[index] == null){
                return false;
            }
            current = current.child[index];
        }
        if(current.isWord && current != null) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(current.child[index] == null){
                return false;
            }
            current = current.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */