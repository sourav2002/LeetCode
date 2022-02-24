class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(s);
        String rev = new StringBuffer(s).reverse().toString();
        return s.equals(rev);
    }
}