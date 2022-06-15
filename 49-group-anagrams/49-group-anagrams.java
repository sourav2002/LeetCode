class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        if(strs.length == 0){
            return list;
        }
    
        Map<String, ArrayList<String>> map = new HashMap();
        
        for(String s : strs){
            String ns = sort(s);
            if(map.containsKey(ns)){
                map.get(ns).add(s);
            }else{
                map.put(ns, new ArrayList<String>());
                map.get(ns).add(s);
            }
        }
        System.out.println(map);
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
        
    }
    
    public String sort(String s){
        char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
        return ns;
    }
}