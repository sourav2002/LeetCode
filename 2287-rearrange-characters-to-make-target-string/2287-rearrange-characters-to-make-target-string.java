class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freqt = new int[26];
        for(int i=0; i<target.length(); i++){
            int ind = target.charAt(i) - 'a';
            freqt[ind]++;
        }
        
        int[] freqs = new int[26];
        for(int i=0; i< s.length();i++){
            int ind = s.charAt(i) - 'a';
            freqs[ind]++;
        }
        int c = 0;
        
        while(true){
            for(int i=0; i<26;i++){
                if(freqs[i] >= freqt[i]){
                    freqs[i] = freqs[i] - freqt[i];
                }else{
                    return c;
                }
            }
            c++;
        }
    }
}