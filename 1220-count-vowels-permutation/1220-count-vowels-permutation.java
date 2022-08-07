class Solution {
    int mod = 1000000000 + 7;

    Map<String, Long> map = new HashMap();
    public int countVowelPermutation(int n) {
        long total = 0;
        char[] arr = { 'a', 'e', 'i', 'o', 'u' };

        for (char c : arr) {
            total =  (total + helper(c, n - 1) ) % mod;
        }

        return (int) total;
    }

    public long helper(char prevChar, int remainingChar) {
        if (remainingChar == 0) return 1;
        long total = 0;
        String  key = "" + remainingChar + prevChar;
        if(map.containsKey(key)) return map.get(key);
        switch (prevChar) {
            case 'a':
                total = (helper('e', remainingChar - 1)) % mod;
                break;
            case 'e':
                total = (helper('a', remainingChar - 1) + helper('i', remainingChar - 1)) % mod;
                break;
            case 'i':
                total = ( helper('a', remainingChar - 1) + helper('e', remainingChar - 1) + helper('o', remainingChar - 1) + helper('u', remainingChar - 1)) % mod;
                break;
            case 'o':
                total = (helper('i', remainingChar - 1) + helper('u', remainingChar - 1)) % mod;
                break;
            case 'u':
                total = (helper('a', remainingChar - 1)) % mod;
                break;
        }
        map.put(key, total);
        return total;
    }
}
