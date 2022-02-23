class Solution {
    public String reverseWords(String s) {
        System.out.println(s);
        String[] words = s.trim().split(" +"); // 1st
        System.out.println(Arrays.toString(words));
        Collections.reverse(Arrays.asList(words)); // 2nd
        System.out.println(Arrays.asList(words));
        String ans = String.join(" ", words); // 3rd
        System.out.println(ans);
        System.out.println();
        return ans;
    }
}