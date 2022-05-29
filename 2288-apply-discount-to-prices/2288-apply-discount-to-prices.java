class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            String word = words[i], num = word.substring(1);
            if (word.length() > 1 && word.charAt(0) == '$' && num.chars().allMatch(j -> '0' <= j && j <= '9')){
                words[i] = '$' + String.format("%.2f", Long.parseLong(num) * (1 - discount / 100d));
            }
        }
        return String.join(" ", words);
    }
}
/*
class Solution {
    public String discountPrices(String s, int discount) {
        String[] word = s.split(" ");
        boolean first = true;
        StringBuilder sb = new StringBuilder();

        for (String w : word) {
            if (!first) {
                sb.append(" ");
            }
            first = false;
            long num = getPrice(w);
            if (num == -1) {
                sb.append(w);
            } else {
                sb.append("$").append(getdiscount(num, discount));
            }
        }
        return sb.toString();
    }

    public long getPrice(String s) {
        if (s.charAt(0) != '$') {
            return -1;
        }
        s = s.substring(1);
        long num = -1;
        try {
            num = Long.parseLong(s);
        } catch (Exception e) {
            return -1;
        }
        return num;
    }

    public String getdiscount(long num, int discount) {
        double newPrice = num - ((num * discount) / 100.0);
        return String.format("%.2f", newPrice);
    }
}
*/
