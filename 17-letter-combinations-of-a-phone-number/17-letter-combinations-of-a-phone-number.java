class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add(0, "");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            int size = ans.size(); // number of nodes/strings already in the queue
            for (int k = 1; k <= size; k++) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray()) ans.add(t + s);
            }
        }
        return ans;
    }
}
/*
class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) return list;
        
        Map<Character,  String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtrack(digits, 0, map, new StringBuilder(), list);
        return list;
    }
    
    public static void backtrack(String digits, int i, Map<Character, String> map, StringBuilder sb, List<String> list){
        if(i == digits.length()){
            list.add(sb.toString());
            return;
        }
        
        String curr = map.get(digits.charAt(i));
        
        for(int k = 0;k<curr.length(); k++){
            sb.append(curr.charAt(k));
            backtrack(digits, i+1, map, sb, list);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
*/
