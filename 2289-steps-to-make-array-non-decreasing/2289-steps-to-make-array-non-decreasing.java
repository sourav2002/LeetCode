class Solution {

    public int totalSteps(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Stack<Pair> st = new Stack();
        st.push(new Pair(nums[n - 1], 0));
        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && nums[i] > st.peek().num) {
                count = Math.max(count + 1, st.peek().val);
                st.pop();
            }
            ans = Math.max(ans, count);
            st.push(new Pair(nums[i], count));
        }
        return ans;
    }
}

class Pair {
    int num;
    int val;

    public Pair(int n, int v) {
        num = n;
        val = v;
    }
}
