class Solution {
    public boolean isSubsequence(String s, String t) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        for(int i=0; i< s.length(); i++){ 
            if(sb.indexOf(String.valueOf(s.charAt(i))) != -1){
                int rm = sb.indexOf(String.valueOf(s.charAt(i)));
                System.out.println("index of " + rm);
                sb = new StringBuilder(sb.substring(rm+1));
            }else{
                return false;
            }  
        }
        
        return true;
    }
}