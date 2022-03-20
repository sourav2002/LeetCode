class Solution {
    public int countCollisions(String d) {
// remove extreme left and right cars and all the cars btwn left and right are going to make a collision

        int left = 0;
        int right = d.length()-1;
        while(left < d.length() && d.charAt(left) == 'L'){
            left++;
        }
        
        while(right >= 0 && d.charAt(right) == 'R'){
            right--;
        }
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (d.charAt(i) != 'S') {
                count++;
            }
        }
		//combining these three loops - TC : O(N).
        
        return count;
    }
}