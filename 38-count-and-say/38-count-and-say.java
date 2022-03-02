class Solution {
    public String countAndSay(int n) {
        if(n==1) return new String("1");
        if(n==2) return new String("11");
        String s = "11";
        for(int i =3; i<=n;i++){
            s = s + '$';
            // System.out.println(s);
            String t = "";
            int c = 1;
            for(int j =1; j<s.length(); j++){
                if(s.charAt(j) != s.charAt(j-1)){
                    t = t + c + s.charAt(j-1);
                    c = 1;
                }else{
                    c++;
                }
            }
            s = t;
        }
        return s;
    }
}