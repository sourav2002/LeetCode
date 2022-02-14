class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;
        int n = num.length;
        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            int target_3 = target - num[i];
            
            for (int j = i + 1; j < n; j++) {
                int target_2 = target_3 - num[j];
                int front = j + 1;
                int back = n - 1;
                
                while (front < back) {
                    int two_sum = num[front] + num[back];
                    
                    if (two_sum < target_2) front++;
                    
                    else if (two_sum > target_2) back--;
                    
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;
                    }
                }//end of while loop
                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j]) ++j;
            }
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;
        }// end of 1st for loop
        return res;
    }
}
/*

Approach: 
Sort the array, and then fix two pointers(use 2 for loops), so the remaining sum will be (target – (nums[i] + nums[j])). 
Now we can fix two pointers, one front, and another back, and easily use a two-pointer to find the remaining two numbers of the quad. In order to avoid duplications, we jump the duplicates, because taking duplicates will result in repeating quads. We can easily jump duplicates, by skipping the same elements by running a loop.
*/