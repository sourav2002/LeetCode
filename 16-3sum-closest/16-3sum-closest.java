class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;

        for(int i = 0; i < nums.length - 2; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int left = i + 1, right = nums.length - 1;
                while(left < right){
                    sum = nums[left] + nums[right] + nums[i];
                    if(sum < target){
                        while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                    }else if(sum > target){
                        while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else{
                        return sum;
                    }
                    if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                        closestSum = sum;
                    }
                }
            }

        }
        return closestSum;
    }
}