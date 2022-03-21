class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();
        
        // store the last occurence of every character in hashmap
        Map<Character, Integer> map = new HashMap();
        for(int i =0; i< s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        
        int first = 0; int last = 0;
        while(first < s.length()){
            last = map.get(s.charAt(first));
            int i = first;
            while(++i < last){
                if(map.get(s.charAt(i)) > last){
                    last = map.get(s.charAt(i));
                }
            }
            ans.add(last-first+1);
            first = last+1;
        }
        return ans;
        
    }
}