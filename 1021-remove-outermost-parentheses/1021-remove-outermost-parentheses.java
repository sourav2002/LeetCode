class Solution {

    public String removeOuterParentheses(String str) {
        StringBuilder sb = new StringBuilder();

        int opened = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                if (opened > 0) {
                    sb.append(c);
                }
                opened++;
            } else {
                if (opened > 1) {
                    sb.append(c);
                }
                opened--;
            }
        }
        return sb.toString();
    }
}
