class Solution {
    public int minDeletions(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        s = new String(temp);
        char[] arr = new char[26];
        int delete = 0;
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        
        char prev = '*';
        HashSet<Integer> map = new HashSet();
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == prev) continue;
            int freq = arr[s.charAt(i) - 'a'];
            while(map.contains(freq)){
                freq--;
                delete++;
                if(freq == 0){
                    break;
                }
            }
            if(freq != 0) map.add(freq);
            prev = s.charAt(i);
        }
        return delete;
    }
}