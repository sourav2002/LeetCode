class Solution{
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);  // update j with last occurance char's index + 1
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}   
/*
the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
*/

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
        
//         char[] arr = s.toCharArray();
//         Map<Character, Integer> map = new HashMap<Character, Integer>();
//         int count =0;
//         int maxCount = 0;
//         for(int i=0; i<s.length(); i++){
//             if(map.containsKey(arr[i])){
//                 maxCount = Math.max(maxCount, count);
//                 count = 1;
//                 int tempi = map.get(arr[i])+1;
//                 map.clear();
                
//                 map.put(arr[tempi], tempi);
//                 i = tempi;
//             }else{
//                 count++;
//                 map.put(arr[i], i);
//             }
            
//         }
        
//         return Math.max(maxCount, count);
//     }
// }