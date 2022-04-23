class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums); // Sort the array
        
        int n = nums.length;
        int maxNumsInWindow = 0;
        
        Deque<Integer> numsInWindow = new ArrayDeque<>();
        for (int num : nums) {
            // Advance the window
            while (numsInWindow.size() > 0 && num - numsInWindow.peekFirst() >= n) {
                numsInWindow.poll();
            }
            
            // Add the new number to the window (if it's not a duplicate)
            if(numsInWindow.size() == 0 || ! numsInWindow.peekLast().equals(num)) {
                numsInWindow.offer(num);            
            }
            
            maxNumsInWindow = Math.max(maxNumsInWindow, numsInWindow.size());
        }
        
        return n - maxNumsInWindow;
    }
}
/*
The intuition is to find the maximum number of distinct elements fitting in a window of length maxNumsInWindow, by iterating over the sorted array.
=> The remaining N - maxNumsInWindow elements need to be replaced.

For example, if we have in = [1, 2, 8, 9, 11], the window has length 5. As we iterate, the window contains:

[1]
[1,2]
[8] (we removed 1 and 2, because more distant than 5)
[8,9]
[8,9,11] (=> maxNumsInWindow = 3 => N - maxNumsInWindow = 2 elements to replace)
*/