class Solution {
    public boolean backspaceCompare(String s, String t) {
        String st = "";
        String tst = "";
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '#'){
                if(st.length() == 0){
                    continue;
                }
                st = st.substring(0, st.length()-1);
            } else{
                st += s.charAt(i);
            }
        }
        for(int i = 0; i<t.length(); i++){
            if(t.charAt(i)== '#'){
                if(tst.length() == 0){
                    continue;
                }
                tst = tst.substring(0, tst.length()-1);
            }else{
                tst += t.charAt(i);
            }
        }
        return st.equals(tst);
    }
}