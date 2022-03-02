class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        
        // using z-index string algorithm
        String nst = needle+"$"+haystack;
        System.out.println(nst);
        
        int[] z = new int[nst.length()];
        z = calculateZ(nst);
        
        System.out.println(Arrays.toString(z));
        
        for(int i=0; i< z.length; i++){
            if(z[i] == needle.length()){
                return i- needle.length() -1;
            }
        }
        
        return -1;
    }
    
    public static int[] calculateZ(String s){
        int[] z = new int[s.length()];
        char[] carr = s.toCharArray();
        
        int left = 0, right = 0;
        for(int k = 1; k < s.length(); k++){
            
            if(k > right){
                left = right = k;
                while(right < s.length() && carr[right] == carr[right - left]){
                  right++;
                }
                z[k] = right - left;
                right--;
            }else{
                int k1 = k - left;
                if(z[k1] < right - k +1){
                    z[k] = z[k1];
                }else{
                    left = k;
                    while(right < s.length() && carr[right] == carr[right- left]){
                        right++;
                    }
                    z[k] = right - left;
                    right--;
                }  
            }
        }
        return z;
                
        // return haystack.indexOf(needle);
    }
}