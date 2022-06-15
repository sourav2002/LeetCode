/*
1) to check if 2 strings are anagram, we can sort both of them and then put in hashmap sorted string as key and original string as value.
2) we can use hashing to get frequency of char in a string. If frequency mapping of 2 strings are same, then we can put them in hashmap to hasing array as key and list of having same freq set strings.
*/

// solution 2
class Solution{
        public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

/*
// solution 1
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        if(strs.length == 0){
            return list;
        }
        Map<String, ArrayList<String>> map = new HashMap();
        for(String s : strs){
            String ns = sort(s);
            if(!map.containsKey(ns)) map.put(ns, new ArrayList<String>());
            map.get(ns).add(s);
        }
        return new ArrayList<>(map.values());
        
    }
    
    public String sort(String s){
        char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
        return ns;
    }
}
*/