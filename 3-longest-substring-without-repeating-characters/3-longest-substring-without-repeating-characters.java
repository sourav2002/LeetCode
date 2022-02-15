class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count =0;
        int maxCount = 0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(arr[i])){
                maxCount = Math.max(maxCount, count);
                count = 1;
                int tempi = map.get(arr[i])+1;
                map.clear();
                
                map.put(arr[tempi], tempi);
                i = tempi;
            }else{
                count++;
                map.put(arr[i], i);
            }
            
        }
        
        return Math.max(maxCount, count);
    }
}