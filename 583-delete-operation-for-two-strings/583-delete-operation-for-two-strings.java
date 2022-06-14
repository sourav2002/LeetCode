public class Solution {
    public int minDistance(String s1, String s2) {
        int[] dp1 = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] dp2=new int[s2.length()+1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp2[j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp2[j] = dp1[j - 1];
                else
                    dp2[j] = 1 + Math.min(dp1[j], dp2[j - 1]);
            }
            dp1 = dp2;
        }
        return dp1[s2.length()];
    }
}