class Solution {

    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        int num_unit = num % 10;
        for (int i = 1; i <= 10; ++i) {
            int cur_unit = (k*i) % 10;
            if(num_unit == cur_unit){
                if(k*i > num) return -1;
                return i;
            }
        }
        return -1;
    }
}
