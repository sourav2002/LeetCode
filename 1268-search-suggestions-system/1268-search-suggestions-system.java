// using trie data structure
class Solution {

    class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products) { // build Trie.
            insert(p, root); // insert a product into Trie.
        }
        return search(searchWord, root);
    }

    private void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) { // insert current product into Trie.
            if (t.sub[c - 'a'] == null) t.sub[c - 'a'] = new Trie();
            t = t.sub[c - 'a'];
            t.suggestion.offer(p); // put products with same prefix into suggestion list.
            Collections.sort(t.suggestion);
            if (
                t.suggestion.size() > 3
            ) t.suggestion.pollLast(); // maintain 3 lexicographically minimum strings.
        }
    }

    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (
                root != null
            ) root = root.sub[c - 'a']; // if there exist products with current prefix.
            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }
}
// brute force solution
// time complexity = n * m * o (where n is the size of searchWOrd len and m is size of products array and o is the size of each string in array)
/*
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList();
        Arrays.sort(products);
        String s = "";
        for(int i=0; i<searchWord.length(); i++){
            char c = searchWord.charAt(i);
            s += c;
            List<String> row = new ArrayList();
            int cnt = 0;
            for(int j = 0; j<products.length; j++){    
                if(products[j].startsWith(s)){
                    row.add(products[j]);
                    cnt++;
                }
                
                if(cnt == 3){
                    break;
                }
            }
            list.add(row);
        }
        return list;
    }
}
*/
