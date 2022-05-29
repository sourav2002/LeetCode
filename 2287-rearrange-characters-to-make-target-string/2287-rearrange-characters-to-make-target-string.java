class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for(int i=0;i<s.length();i++){
            sc[s.charAt(i)-'a']++;
        }
        for(int i=0;i<target.length();i++){
            tc[target.charAt(i)-'a']++;
        }
        int ans = s.length();
        for(int i=0;i<26;i++){
            if(tc[i]!=0) {
                ans = Math.min(ans,sc[i]/tc[i]);
            }
        }
        return ans;
    }
}
