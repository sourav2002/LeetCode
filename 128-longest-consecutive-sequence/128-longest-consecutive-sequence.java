class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        
        int longestStreak = 0;
        for(int n : nums){
            if(!hs.contains(n-1)){ 
                // check if the current number is the starting no. of consecutive seq or not 
                int currentNum = n;
                int currentStreak = 1;
                
                while(hs.contains(currentNum +1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
/*
put all numbers of array in a hashmap because it is easy to check if an array has x element or not
now run a for loop and check if the number has not any previous value because we need consecutive sequence and it requires 1st element to be smallest in the subset of consecutive seq.
 
 check if hashmap contains( current num + 1 ) if yes then update currentnum and increment current streak of sequence 
*/